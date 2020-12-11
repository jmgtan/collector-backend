package org.humanitarian.collector.services;

import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.springframework.data.domain.Page;

public interface DataService {
    int PAGE_SIZE = 10;

    Page<Person> listPersons(int page);

    Page<Demographic> listDemographics(int page);
}
