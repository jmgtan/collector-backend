package org.humanitarian.collector.controllers;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
import org.humanitarian.collector.controllers.responses.BasicListMessageResponse;
import org.humanitarian.collector.controllers.responses.PaginatedListMessageResponse;
import org.humanitarian.collector.exceptions.HandlerNotFoundException;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.services.BatchDataFileService;
import org.humanitarian.collector.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private BatchDataFileService batchDataFileService;

    @GetMapping("/persons/list")
    public PaginatedListMessageResponse<Person> listOfPersons(@RequestParam(name = "page", defaultValue = "1") int page) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listPersons(page));
    }

    @GetMapping("/demographics/list")
    public PaginatedListMessageResponse<Demographic> listOfDemographics(@RequestParam(name = "page", defaultValue = "1") int page) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listDemographics(page));
    }

    @PostMapping(value = "/upload-batch-data-file", consumes = "multipart/form-data", produces = "application/json")
    public BasicEntityMessageResponse<BatchDataFile> uploadBatchDataFile(@AuthenticationPrincipal User user, @RequestParam("file") MultipartFile multipartFile, @RequestParam("type") String dataFileType) throws IOException, HandlerNotFoundException {
        return new BasicEntityMessageResponse<>(HttpStatus.OK, batchDataFileService.process(user, multipartFile.getInputStream(), dataFileType));
    }

    @GetMapping(value = "/available-handlers", produces = "application/json")
    public BasicListMessageResponse<String> listAvailableHandlers() {
        return new BasicListMessageResponse<String>(HttpStatus.OK, batchDataFileService.getAvailableHandlers());
    }
}
