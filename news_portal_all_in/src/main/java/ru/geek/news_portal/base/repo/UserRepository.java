package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

    boolean existsByUsername(String username);

    User findOneById(Long id);
}
