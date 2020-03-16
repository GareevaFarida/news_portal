package ru.geek.news_portal.base.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findOneByUsername(String username);

  boolean existsByUsername(String username);
}
