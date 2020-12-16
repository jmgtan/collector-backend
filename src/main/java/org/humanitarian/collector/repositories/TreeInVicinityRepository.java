package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.FormData;
import org.humanitarian.collector.models.TreeInVicinity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TreeInVicinityRepository extends CrudRepository<TreeInVicinity, UUID> {
    void deleteByFormData(FormData formData);
}
