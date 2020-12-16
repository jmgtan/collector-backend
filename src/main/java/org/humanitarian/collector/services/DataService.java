package org.humanitarian.collector.services;

import org.humanitarian.collector.models.Barangay;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface DataService {
    int PAGE_SIZE = 10;

    Page<Person> listPersons(int page, String sortColumn, Sort.Direction direction);

    Page<Demographic> listDemographics(int page, String sortColumn, Sort.Direction direction);

    Page<Barangay> listBarangay(int page, String sortColumn, Sort.Direction direction);
}
