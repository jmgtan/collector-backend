package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;
import java.util.UUID;

public interface PersonRepository extends PagingAndSortingRepository<Person, UUID> {
    Person findOneByFirstNameAndLastNameAndDob(String firstName, String lastName, Date dob);
    Person findOneByFirstNameAndMiddleNameAndLastNameAndDob(String firstName, String middleName, String lastName, Date dob);
}
