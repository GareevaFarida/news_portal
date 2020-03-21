package ru.geek.news_portal.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.utils.SystemUser;

public interface UserService extends UserDetailsService {
  User findByUsername(String username);
  boolean isUsernameExist(String username);
  boolean isEmailExist(String email);
  User save(SystemUser systemUser);

}
