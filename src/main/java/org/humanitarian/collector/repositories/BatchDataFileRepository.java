package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.BatchDataFile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BatchDataFileRepository extends PagingAndSortingRepository<BatchDataFile, Integer> {

}
