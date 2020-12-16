package org.humanitarian.collector.controllers;

import org.humanitarian.collector.controllers.requests.BarangayFormDataRequest;
import org.humanitarian.collector.controllers.requests.DemographicFormDataRequest;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
import org.humanitarian.collector.controllers.responses.BasicListMessageResponse;
import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.DemographicFormData;
import org.humanitarian.collector.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collector")
public class CollectorController {

    private static final String SOURCE_KOBO = "kobo";

    @Autowired
    private SubmissionService submissionService;

    @PostMapping(path="/kobo/demographics", consumes = "application/json", produces = "application/json")
    public BasicEntityMessageResponse<DemographicFormData> receiveDemographicsData(@RequestBody DemographicFormDataRequest request) {
        request.setSourceSystem(SOURCE_KOBO);
        DemographicFormData d = submissionService.saveDemographicFormDataRequest(request);
        return new BasicEntityMessageResponse<>(HttpStatus.OK, d);
    }

    @PostMapping(value = "/kobo/barangay", consumes = "application/json", produces = "application/json")
    public BasicListMessageResponse<BarangayFormData> receiveBarangayData(@RequestBody BarangayFormDataRequest request) {
        request.setSourceSystem(SOURCE_KOBO);
        List<BarangayFormData> entities = submissionService.saveBarangayFormDataRequest(request);
        return new BasicListMessageResponse<>(HttpStatus.OK, entities);
    }
}
