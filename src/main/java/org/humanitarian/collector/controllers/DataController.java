package org.humanitarian.collector.controllers;

import org.humanitarian.collector.controllers.responses.PaginatedListMessageResponse;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/persons/list")
    public PaginatedListMessageResponse<Person> listOfPersons(@RequestParam(name = "page", defaultValue = "1") int page) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listPersons(page));
    }

    @GetMapping("/demographics/list")
    public PaginatedListMessageResponse<Demographic> listOfDemographics(@RequestParam(name = "page", defaultValue = "1") int page) {
        return new PaginatedListMessageResponse<>(HttpStatus.OK, dataService.listDemographics(page));
    }
}
