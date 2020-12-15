package org.humanitarian.collector.services;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.exceptions.HandlerNotFoundException;
import org.humanitarian.collector.exceptions.InvalidFileFormatException;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.repositories.BatchDataFileRepository;
import org.humanitarian.collector.services.batch.handler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.*;

@Service
public class BatchDataFileServiceImpl implements BatchDataFileService {

    @Autowired
    private List<FileHandler> fileHandlers;

    private Map<String, FileHandler> fileHandlerMap;

    @Autowired
    private BatchDataFileRepository batchDataFileRepository;

    @Override
    @Transactional
    public BatchDataFile process(User user, InputStream inputStream, String type) throws HandlerNotFoundException {
        String handlerType = type.toLowerCase();
        FileHandler handler = fileHandlerMap.get(handlerType+"-csv");

        if (handler == null) {
            throw new HandlerNotFoundException();
        }

        BatchDataFile batchDataFile = new BatchDataFile();
        batchDataFile.setUser(user);
        batchDataFile.setHandlerType(handlerType);
        batchDataFileRepository.save(batchDataFile);

        try {
            handler.handle(batchDataFile, inputStream);
        } catch (InvalidFileFormatException | IOException e) {
            batchDataFile.setStatus(BatchDataFile.STATUS_FAILED);
            batchDataFile.setErrorMessage(e.getMessage());
        } finally {
            batchDataFile.setStatus(BatchDataFile.STATUS_PROCESSED);
        }

        batchDataFile.setProcessedDate(new Date(System.currentTimeMillis()));
        batchDataFileRepository.save(batchDataFile);

        return batchDataFile;
    }

    @Override
    public Set<String> getAvailableHandlers() {
        if (!fileHandlerMap.isEmpty()) {
            Set<String> keys = fileHandlerMap.keySet();
            Set<String> handlers = new HashSet<>();
            for (String key : keys) {
                handlers.add(fileHandlerMap.get(key).getIdentifier());
            }

            return handlers;
        }

        return new HashSet<>();
    }

    @PostConstruct
    private void mapFileHandlers() {
        fileHandlerMap = new HashMap<>();

        if (fileHandlers != null && !fileHandlers.isEmpty()) {
            for (FileHandler f : fileHandlers) {
                fileHandlerMap.put(f.getIdentifier()+"-"+f.getFormat(), f);
            }
        }
    }
}
