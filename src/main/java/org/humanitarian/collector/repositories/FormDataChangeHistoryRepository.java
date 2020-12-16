package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.FormDataChangeHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface FormDataChangeHistoryRepository extends PagingAndSortingRepository<FormDataChangeHistory, UUID> {
    Page<FormDataChangeHistory> findByFormData(FormData formData, Pageable page);
}
