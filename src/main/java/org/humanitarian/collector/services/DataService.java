package org.humanitarian.collector.services;

import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.DemographicFormData;
import org.humanitarian.collector.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface DataService {
    int PAGE_SIZE = 10;

    Page<Person> listPersons(int page, String sortColumn, Sort.Direction direction);

    Page<DemographicFormData> listDemographics(int page, String sortColumn, Sort.Direction direction);

    Page<BarangayFormData> listBarangay(int page, String sortColumn, Sort.Direction direction);
}
