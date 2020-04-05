package ru.geek.news_portal.base.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geek.news_portal.base.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * @author Stanislav Ryzhkov
     * Created 05/04/2020
     * Метод, возвращающий статьи, сортированные по дате публикации
     */
    Page<Article> findAllByOrderByPublishedDesc(Pageable pageable);

    /**
     * @author Stanislav Ryzhkov
     * Created 05/04/2020
     * Метод, возвращающий статьи, сортированные по кол-ву просмотров
     */
    Page<Article> findAllByOrderByTotalViewsDesc(Pageable pageable);
}
