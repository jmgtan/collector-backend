package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BarangayFormDataRepository extends PagingAndSortingRepository<BarangayFormData, UUID> {
    BarangayFormData findOneByPerson(Person person);
}
