package ru.geek.news_portal.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.geek.news_portal.base.entities.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Article dto.
 * @author Stanislav Ryzhkov
 * Created 28/03/2020
 * Data transfer object
 * Иммутабельный класс для работы со слоем представления данных во избежание
 * конфликтов с Hibernate
 */
@Getter
@RequiredArgsConstructor
public final class ArticleDto {
    private final Long id;
    private final LocalDateTime created;
    private final String title;
    private final String text;
    private final LocalDateTime published;
    private final ArticleCategory category;
    private final Long totalViews;
    private final LocalDateTime lastViewDate;
    private final String mainPictureUrl;
    private final Status status;
    private final List<Comment> comments;
//    private final List<ArticleLike> likes;
    private final List<Tag> tags;
    private final List<ArticleRating> ratings;
}
