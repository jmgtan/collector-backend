package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FoodProductionActivity;
import org.humanitarian.collector.models.FormData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FoodProductionActivityRepository extends CrudRepository<FoodProductionActivity, UUID> {
    void deleteByFormData(FormData formData);
}
