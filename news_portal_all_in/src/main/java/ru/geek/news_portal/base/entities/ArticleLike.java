package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Farida Gareeva
 * Created 14/03/2020
 * v1.0
 * A table for storage likes and dislikes of articles by authorized users.
 * like = 1 if an user likes an article
 * like = -1 if an user dislikes an article
 */

@NoArgsConstructor
@Entity
@Table(name = "article_likes")
@Data
@Getter
@Setter
public class ArticleLike {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    Long id;
//

    @EmbeddedId
    private ArticleUserKey id;

//    @JsonManagedReference
//    @ManyToOne(optional = false)
//    Article article;
//
//    @JsonManagedReference
//    @ManyToOne(optional = false)
//    User user;


    @Column(name = "value")
    private int value;

    public void setId(Article article, User user){
        this.id = new ArticleUserKey(article, user);
    }

    @Embeddable
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    public class ArticleUserKey implements Serializable {

        @Getter
        @Setter
        private Article article;

        @Getter
        @Setter
        private User user;

        public ArticleUserKey(Article article, User user) {
            this.article = article;
            this.user = user;
        }
    }
}
