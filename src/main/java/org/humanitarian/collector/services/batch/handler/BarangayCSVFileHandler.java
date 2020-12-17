package org.humanitarian.collector.services.batch.handler;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;
import org.humanitarian.collector.controllers.requests.BarangayFormDataBatchRow;
import org.humanitarian.collector.controllers.requests.BarangayFormDataRequest;
import org.humanitarian.collector.exceptions.InvalidFileFormatException;
import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.BatchDataFile;
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
public class BarangayCSVFileHandler implements FileHandler<BarangayFormData> {

    @Autowired
    private SubmissionService submissionService;

    @Override
    @Transactional
    public List<BarangayFormData> handle(BatchDataFile batchDataFile, InputStream inputStream) throws InvalidFileFormatException, IOException {
        BOMInputStream bin = new BOMInputStream(inputStream);

        List<BarangayFormDataBatchRow> rows = new CsvToBeanBuilder<BarangayFormDataBatchRow>(new InputStreamReader(bin, StandardCharsets.UTF_8))
                .withType(BarangayFormDataBatchRow.class)
                .build().parse();

        List<BarangayFormData> results = new ArrayList<>(rows.size() + 1);

        for (BarangayFormDataBatchRow row : rows) {
            results.addAll(submissionService.saveBarangayFormDataRequest(row.toFormDataRequest()));
        }

        return results;
    }

    @Override
    public String getIdentifier() {
        return "barangay";
    }

    @Override
    public String getFormat() {
        return "csv";
    }
}
