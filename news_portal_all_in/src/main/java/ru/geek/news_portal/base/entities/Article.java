package ru.geek.news_portal.base.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "articles")
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "title", unique = true)
  private String title;

  @Column(name = "text", length = 10000)
  private String text;

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<ArticleLike> likes = new ArrayList<>();

  @JsonBackReference
  @OneToMany(mappedBy = "article",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Comment> comments = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<ArticleLike> getLikes() {
    return likes;
  }

  public void setLikes(List<ArticleLike> likes) {
    this.likes = likes;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public void addLike(ArticleLike like) {
    likes.add(like);
  }

  public void removeLike(ArticleLike like) {
    likes.remove(like);
  }

  public void addComment(Comment comment) {
    comments.add(comment);
  }

  public void removeComment(Comment comment) {
    comments.remove(comment);
  }

}
