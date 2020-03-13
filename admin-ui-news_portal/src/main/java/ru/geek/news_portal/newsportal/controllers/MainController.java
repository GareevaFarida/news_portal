package ru.geek.news_portal.newsportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geek.news_portal.newsportal.services.ArticleService;

@Controller
public class MainController {
  private ArticleService articleService;

  @Autowired
  public void setArticleService(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("articles", articleService.findAllArticles());
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/admin")
  @ResponseBody
  public String admin() {
    return "Hello";
  }

}