package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.GovernmentProgram;
import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GovernmentProgramRepository extends CrudRepository<GovernmentProgram, UUID> {
    void deleteByPerson(Person p);
}
