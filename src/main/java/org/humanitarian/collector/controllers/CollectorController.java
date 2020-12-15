package org.humanitarian.collector.controllers;

import org.humanitarian.collector.controllers.requests.BarangayRequest;
import org.humanitarian.collector.controllers.requests.DemographicRequest;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
import org.humanitarian.collector.models.Barangay;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collector")
public class CollectorController {

    private static final String SOURCE_KOBO = "kobo";

    @Autowired
    private SubmissionService submissionService;

    @PostMapping(path="/kobo/demographics", consumes = "application/json", produces = "application/json")
    public BasicEntityMessageResponse<Demographic> receiveDemographicsData(@RequestBody DemographicRequest request) {
        request.setSourceSystem(SOURCE_KOBO);
        Demographic d = submissionService.saveDemographicRequest(request);
        return new BasicEntityMessageResponse<>(HttpStatus.OK, d);
    }

    @PostMapping(value = "/kobo/barangay", consumes = "application/json", produces = "application/json")
    public BasicEntityMessageResponse<Barangay> receiveBarangayData(@RequestBody BarangayRequest request) {
        request.setSourceSystem(SOURCE_KOBO);
        Barangay b = submissionService.saveBarangayRequest(request);
        return new BasicEntityMessageResponse<>(HttpStatus.OK, b);
    }
}
