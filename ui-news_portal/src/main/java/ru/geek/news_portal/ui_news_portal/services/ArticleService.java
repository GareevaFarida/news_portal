package ru.geek.news_portal.ui_news_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.news_portal.newsportal.entities.Article;
import ru.geek.news_portal.newsportal.repo.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

  private ArticleRepository articleRepository;

  @Autowired
  public void setArticleRepository(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public List<Article> findAllArticles() {
    return (List<Article>) articleRepository.findAll();
  }
}
