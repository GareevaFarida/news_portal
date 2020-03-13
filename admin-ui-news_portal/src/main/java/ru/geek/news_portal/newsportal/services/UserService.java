package ru.geek.news_portal.newsportal.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geek.news_portal.newsportal.entities.User;
import ru.geek.news_portal.newsportal.utils.SystemUser;

public interface UserService extends UserDetailsService {
  User findByUsername(String username);
  boolean isUserExist(String username);
  User save(SystemUser systemUser);
}
