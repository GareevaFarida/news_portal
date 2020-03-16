package ru.geek.news_portal.base.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String name);
}