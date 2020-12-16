package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.LivelihoodEquipment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LivelihoodEquipmentRepository extends CrudRepository<LivelihoodEquipment, UUID> {
    void deleteByFormData(FormData formData);
}
