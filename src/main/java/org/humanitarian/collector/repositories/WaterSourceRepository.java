package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.WaterSource;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WaterSourceRepository extends CrudRepository<WaterSource, UUID> {
    void deleteByFormData(FormData formData);
}
