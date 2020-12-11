package org.humanitarian.collector.auth.repositories;

import org.humanitarian.collector.auth.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findOneByUsername(String username);
    User findOneByUsernameAndPassword(String username, String password);
}
