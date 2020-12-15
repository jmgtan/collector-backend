package org.humanitarian.collector.services.batch.handler;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;
import org.humanitarian.collector.controllers.requests.DemographicRequest;
import org.humanitarian.collector.exceptions.InvalidFileFormatException;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemographicCSVFileHandler implements FileHandler<Demographic> {

    @Autowired
    private SubmissionService submissionService;

    @Override
    @Transactional
    public List<Demographic> handle(BatchDataFile batchDataFile, InputStream inputStream) throws InvalidFileFormatException, IOException {
        BOMInputStream bin = new BOMInputStream(inputStream);

        List<DemographicRequest> rows = new CsvToBeanBuilder<DemographicRequest>(new InputStreamReader(bin, StandardCharsets.UTF_8))
                .withType(DemographicRequest.class)
                .build()
                .parse();

        List<Demographic> results = new ArrayList<>(rows.size() + 1);

        for (DemographicRequest kdr : rows) {
            results.add(submissionService.saveDemographicWithBatch(kdr, batchDataFile));
        }

        return results;
    }

    @Override
    public String getIdentifier() {
        return "demographic";
    }

    @Override
    public String getFormat() {
        return "csv";
    }
}
