package ru.geek.news_portal.newsportal.repo;

import ru.geek.news_portal.newsportal.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findOneByUsername(String username);

  boolean existsByUsername(String username);
}
