package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.Demographic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.UUID;

public interface DemographicRepository extends PagingAndSortingRepository<Demographic, UUID> {
}
