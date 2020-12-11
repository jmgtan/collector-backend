package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.sql.Date;

public interface PersonRepository extends PagingAndSortingRepository<Person, BigInteger> {
    Person findOneByFirstNameAndLastNameAndDob(String firstName, String lastName, Date dob);
}
