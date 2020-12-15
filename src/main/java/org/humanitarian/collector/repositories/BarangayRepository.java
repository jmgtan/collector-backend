package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.Barangay;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BarangayRepository extends PagingAndSortingRepository<Barangay, UUID> {
}
