package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.BatchDataFile;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BatchDataFileRepository extends PagingAndSortingRepository<BatchDataFile, UUID> {

}
