package ru.geek.news_portal.ui_news_portal.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geek.news_portal.newsportal.entities.User;
import ru.geek.news_portal.ui_news_portal.utils.SystemUser;

public interface UserService extends UserDetailsService {
  User findByUsername(String username);
  boolean isUserExist(String username);
  User save(SystemUser systemUser);
}
