package org.humanitarian.collector.services;

import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.repositories.DemographicRepository;
import org.humanitarian.collector.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DemographicRepository demographicRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> listPersons(int page) {
        Pageable sortByLastName = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "lastName"));
        return personRepository.findAll(sortByLastName);
    }

    @Override
    public Page<Demographic> listDemographics(int page) {
        Pageable sortBySubmissionTime = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "submissionTime"));
        return demographicRepository.findAll(sortBySubmissionTime);
    }
}
