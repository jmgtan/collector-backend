package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.TypeOfToilet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TypeOfToiletRepository extends CrudRepository<TypeOfToilet, UUID> {
    void deleteByFormData(FormData formData);
}
