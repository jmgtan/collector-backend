package org.humanitarian.collector.auth.repositories;

import org.humanitarian.collector.auth.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
    Role findOneByName(String name);
}
