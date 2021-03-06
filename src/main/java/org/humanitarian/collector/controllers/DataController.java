package org.humanitarian.collector.controllers;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
import org.humanitarian.collector.controllers.responses.BasicListMessageResponse;
import org.humanitarian.collector.controllers.responses.PaginatedListMessageResponse;
import org.humanitarian.collector.controllers.responses.RootsOfHealthResponse;
import org.humanitarian.collector.exceptions.HandlerNotFoundException;
import org.humanitarian.collector.models.*;
import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.services.BatchDataFileService;
import org.humanitarian.collector.services.DataService;
import org.humanitarian.collector.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private BatchDataFileService batchDataFileService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/persons/list")
    public PaginatedListMessageResponse<Person> listOfPersons(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "sortColumn", defaultValue = "lastName") String sortColumn,
            @RequestParam(name = "sortDirection", defaultValue = "ASC") String sortDirection) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listPersons(page, sortColumn, Sort.Direction.valueOf(sortDirection)));
    }

    @GetMapping("/demographics/list")
    public PaginatedListMessageResponse<DemographicFormData> listOfDemographics(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "sortColumn", defaultValue = "submissionTime") String sortColumn,
            @RequestParam(name = "sortDirection", defaultValue = "DESC") String sortDirection) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listDemographics(page, sortColumn, Sort.Direction.valueOf(sortDirection)));
    }

    @GetMapping("/barangay/list")
    public PaginatedListMessageResponse<BarangayFormData> listOfBarangay(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "sortColumn", defaultValue = "submissionTime") String sortColumn,
            @RequestParam(name = "sortDirection", defaultValue = "DESC") String sortDirection) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listBarangay(page, sortColumn, Sort.Direction.valueOf(sortDirection)));
    }

    @PostMapping(value = "/upload-batch-data-file", consumes = "multipart/form-data", produces = "application/json")
    public BasicEntityMessageResponse<BatchDataFile> uploadBatchDataFile(@AuthenticationPrincipal User user, @RequestParam("file") MultipartFile multipartFile, @RequestParam("type") String dataFileType) throws IOException, HandlerNotFoundException {
        return new BasicEntityMessageResponse<>(HttpStatus.OK, batchDataFileService.process(user, multipartFile.getInputStream(), dataFileType));
    }

    @GetMapping(value = "/available-handlers", produces = "application/json")
    public BasicListMessageResponse<String> listAvailableHandlers() {
        return new BasicListMessageResponse<String>(HttpStatus.OK, batchDataFileService.getAvailableHandlers());
    }

    @GetMapping("/reports/roots-of-health")
    public BasicEntityMessageResponse<RootsOfHealthResponse> rootsOfHealthReport() {
        return new BasicEntityMessageResponse<>(HttpStatus.OK, new RootsOfHealthResponse(reportService.getGeneralDemographicsData(), reportService.getReproductiveHealthData(), reportService.getSanitationData()));
    }

    @GetMapping("/reports/download")
    public BasicEntityMessageResponse<ReportDownload> downloadReport(@AuthenticationPrincipal User user) throws IOException {
        return new BasicEntityMessageResponse<>(HttpStatus.OK, reportService.generateReport(user));
    }
}
