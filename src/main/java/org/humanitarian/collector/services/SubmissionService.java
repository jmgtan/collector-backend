package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.BarangayPersonRequest;
import org.humanitarian.collector.controllers.requests.BarangayFormDataRequest;
import org.humanitarian.collector.controllers.requests.DemographicFormDataRequest;
import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.DemographicFormData;
import org.humanitarian.collector.models.Person;

import java.sql.Date;
import java.util.List;

public interface SubmissionService {
    Person checkOrCreatePersonFromRequest(BarangayPersonRequest request);
    List<BarangayFormData> saveBarangayFormDataRequest(BarangayFormDataRequest request);
    DemographicFormData saveDemographicFormDataRequest(DemographicFormDataRequest request);
    DemographicFormData saveDemographicFormDataWithBatch(DemographicFormDataRequest request, BatchDataFile batchDataFile);
    Person checkOrCreatePerson(String firstName, String lastName, Date dob);
}
