package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.KoboDemographicRequest;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;

import java.sql.Date;

public interface SubmissionService {
    Demographic saveKoboDemographicRequest(KoboDemographicRequest request);
    Demographic saveKoboDemographicWithBatch(KoboDemographicRequest request, BatchDataFile batchDataFile);
    Person checkOrCreatePerson(String firstName, String lastName, Date dob);
}
