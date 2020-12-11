package org.humanitarian.collector.controllers;

import org.humanitarian.collector.controllers.requests.KoboDemographicRequest;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
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

    @Autowired
    private SubmissionService submissionService;

    @PostMapping(path="/receive_data", consumes = "application/json", produces = "application/json")
    public BasicEntityMessageResponse<Demographic> receiveData(@RequestBody KoboDemographicRequest request) {
        Demographic d = submissionService.saveKoboDemographicRequest(request);
        return new BasicEntityMessageResponse<>(HttpStatus.OK, d);
    }
}
