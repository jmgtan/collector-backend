package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FamilyPlanningMethod;
import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FamilyPlanningMethodRepository extends CrudRepository<FamilyPlanningMethod, UUID> {
    void deleteByPerson(Person p);
}
