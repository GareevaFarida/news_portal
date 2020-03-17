package ru.geek.news_portal.base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geek.news_portal.base.entities.ArticleLike;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 */
public interface ArticleLikeRepository extends JpaRepository<ArticleLike,Long> {
}