package org.humanitarian.collector.services.batch.handler;

import org.humanitarian.collector.exceptions.InvalidFileFormatException;
import org.humanitarian.collector.models.BatchDataFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FileHandler<T> {
    public List<T> handle(BatchDataFile batchDataFile, InputStream inputStream) throws InvalidFileFormatException, IOException;
    public String getIdentifier();
    public String getFormat();
}
