package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.IpAffiliation;
import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IpAffiliationRepository extends CrudRepository<IpAffiliation, UUID> {
    void deleteByPerson(Person p);
}
