package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.BarangayPersonRequest;
import org.humanitarian.collector.controllers.requests.BarangayRequest;
import org.humanitarian.collector.controllers.requests.DemographicRequest;
import org.humanitarian.collector.models.Barangay;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;

import java.sql.Date;

public interface SubmissionService {
    Person checkOrCreatePersonFromRequest(BarangayPersonRequest request);
    Barangay saveBarangayRequest(BarangayRequest request);
    Demographic saveDemographicRequest(DemographicRequest request);
    Demographic saveDemographicWithBatch(DemographicRequest request, BatchDataFile batchDataFile);
    Person checkOrCreatePerson(String firstName, String lastName, Date dob);
}
