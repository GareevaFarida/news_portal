


package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geek.news_portal.base.entities.Comment;
import ru.geek.news_portal.services.ArticleService;
import ru.geek.news_portal.services.CommentService;
import ru.geek.news_portal.utils.SystemUser;

@Controller
public class MainController {

  private ArticleService articleService;
  private CommentService commentService;
  //Временное решение до появления сервиса предпочтений пользователя
  private Long RECOMENDED_NEWS = 5L;

  @Autowired
  public void setArticleService(ArticleService articleService) {
    this.articleService = articleService;
  }

  @Autowired
  public void setCommentService(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/")
  public String index(Model model, @PathVariable(value = "id", required = false) Long id) {
    model.addAttribute("articles", articleService.findAllArticles());
    model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
//    model.addAttribute("article", articleService.findById(id));
    return "index";
  }

  @GetMapping("/fragments/news")
  public String fragNews(Model model, @PathVariable(value = "id", required = false) Long id) {
    model.addAttribute("articles", articleService.findAllArticles());
    model.addAttribute("comments", commentService.findAllCommentByArticle_id(RECOMENDED_NEWS));
    model.addAttribute("comment", new Comment());
    model.addAttribute("recomended_news_id", RECOMENDED_NEWS);
//    model.addAttribute("article", articleService.findById(id));
    return "/fragments/news";
  }

  @GetMapping("/login")
  public String login() {
    return "ui/login";
  }

  @GetMapping("/category")
  public String category() {
    return "ui/category";
  }

  @GetMapping("/contact")
  public String contact() {
    return "ui/contact";
  }

  @GetMapping("/forgot")
  public String forgot() {
    return "ui/forgot";
  }

  @GetMapping("/page")
  public String page() {
    return "ui/page";
  }

  @GetMapping("/reset")
  public String reset() {
    return "ui/reset";
  }

  @GetMapping("/search")
  public String search() {
    return "ui/search";
  }

  @GetMapping("/single")
  public String single() {
    return "ui/single";
  }

  @GetMapping("/starter")
  public String starter() {
    return "ui/starter";
  }

  @GetMapping("/403")
  public String permission() {
    return "ui/403";
  }

  @GetMapping("/404")
  public String notFound() {
    return "ui/404";
  }

  @GetMapping("/500")
  public String internalServerError() {
    return "ui/500";
  }

  @GetMapping("/503")
  public String serviceUnavailable() {
    return "ui/503";
  }

//  @GetMapping("/admin")
//  @ResponseBody
//  public String admin() {
//    return "Hello";
//  }
}