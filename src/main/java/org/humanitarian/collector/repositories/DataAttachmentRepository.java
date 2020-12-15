package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.DataAttachment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DataAttachmentRepository extends CrudRepository<DataAttachment, UUID> {
}
