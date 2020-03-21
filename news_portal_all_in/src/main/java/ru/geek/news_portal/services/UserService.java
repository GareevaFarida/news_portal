package ru.geek.news_portal.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.utils.SystemUser;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);

    User findById(Long id);

    boolean isUserExist(String username);

    User save(SystemUser systemUser);

    User saveUser(User user);

    List<User> findAll();

    void delete(Long id);
}
