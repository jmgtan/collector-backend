package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.KoboDemographicRequest;
import org.humanitarian.collector.models.BatchDataFile;
import org.humanitarian.collector.models.Demographic;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.repositories.DemographicRepository;
import org.humanitarian.collector.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private DemographicRepository demographicRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public Demographic saveKoboDemographicRequest(KoboDemographicRequest request) {
        return saveKoboDemographicWithBatch(request, null);
    }

    @Override
    @Transactional
    public Demographic saveKoboDemographicWithBatch(KoboDemographicRequest request, BatchDataFile batchDataFile) {
        Person person = checkOrCreatePerson(request.getFirstName(), request.getLastName(), request.getDateOfBirth());

        Demographic d = new Demographic();

        d.setPerson(person);
        d.setAddress(request.getAddress());
        d.setSubmissionTime(request.getSubmissionTime());
        d.setSourceFormId(request.getSourceFormId());
        d.setTelephoneNumber(request.getTelephoneNumber());
        d.setBatch(batchDataFile);

        demographicRepository.save(d);

        return d;
    }

    @Override
    @Transactional
    public Person checkOrCreatePerson(String firstName, String lastName, Date dob) {
        Person person = personRepository.findOneByFirstNameAndLastNameAndDob(firstName, lastName, dob);

        if (person == null) {
            person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setDob(dob);

            personRepository.save(person);
        }

        return person;
    }
}
