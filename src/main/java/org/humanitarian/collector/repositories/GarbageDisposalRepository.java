package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.GarbageDisposal;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GarbageDisposalRepository extends CrudRepository<GarbageDisposal, UUID> {
    void deleteByFormData(FormData formData);
}
