package org.humanitarian.collector.services.batch.handler;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;
import org.humanitarian.collector.controllers.requests.DemographicFormDataRequest;
import org.humanitarian.collector.exceptions.InvalidFileFormatException;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.DemographicFormData;
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
public class DemographicCSVFileHandler implements FileHandler<DemographicFormData> {

    @Autowired
    private SubmissionService submissionService;

    @Override
    @Transactional
    public List<DemographicFormData> handle(BatchDataFile batchDataFile, InputStream inputStream) throws InvalidFileFormatException, IOException {
        BOMInputStream bin = new BOMInputStream(inputStream);

        List<DemographicFormDataRequest> rows = new CsvToBeanBuilder<DemographicFormDataRequest>(new InputStreamReader(bin, StandardCharsets.UTF_8))
                .withType(DemographicFormDataRequest.class)
                .build()
                .parse();

        List<DemographicFormData> results = new ArrayList<>(rows.size() + 1);

        for (DemographicFormDataRequest kdr : rows) {
            results.add(submissionService.saveDemographicFormDataWithBatch(kdr, batchDataFile));
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
