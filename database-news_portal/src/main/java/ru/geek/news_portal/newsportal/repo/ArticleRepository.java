package ru.geek.news_portal.newsportal.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.newsportal.entities.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
