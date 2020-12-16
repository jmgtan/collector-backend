package org.humanitarian.collector.services;

import org.humanitarian.collector.models.Barangay;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.repositories.BarangayRepository;
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

    @Autowired
    private BarangayRepository barangayRepository;

    @Override
    public Page<Barangay> listBarangay(int page, String sortColumn, Sort.Direction direction) {
        if (sortColumn == null) {
            sortColumn = "submissionTime";
        }

        if (direction == null) {
            direction = Sort.Direction.DESC;
        }

        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(direction, sortColumn));

        return barangayRepository.findAll(pageable);
    }

    @Override
    public Page<Person> listPersons(int page, String sortColumn, Sort.Direction direction) {
        if (sortColumn == null) {
            sortColumn = "lastName";
        }

        if (direction == null) {
            direction = Sort.Direction.ASC;
        }

        Pageable sortByLastName = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(direction, sortColumn));
        return personRepository.findAll(sortByLastName);
    }

    @Override
    public Page<Demographic> listDemographics(int page, String sortColumn, Sort.Direction direction) {
        if (sortColumn == null) {
            sortColumn = "submissionTime";
        }

        if (direction == null) {
            direction = Sort.Direction.DESC;
        }

        Pageable sortBySubmissionTime = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(direction, sortColumn));
        return demographicRepository.findAll(sortBySubmissionTime);
    }
}
