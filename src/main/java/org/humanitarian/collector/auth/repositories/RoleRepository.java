package org.humanitarian.collector.auth.repositories;

import org.humanitarian.collector.auth.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findOneByName(String name);
}
