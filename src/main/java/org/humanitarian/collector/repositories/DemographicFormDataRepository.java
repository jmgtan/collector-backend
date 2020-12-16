package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.DemographicFormData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface DemographicFormDataRepository extends PagingAndSortingRepository<DemographicFormData, UUID> {
}
