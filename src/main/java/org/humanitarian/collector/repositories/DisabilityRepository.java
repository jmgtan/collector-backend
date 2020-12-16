package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.Disability;
import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DisabilityRepository extends CrudRepository<Disability, UUID> {
    void deleteByPerson(Person p);
}
