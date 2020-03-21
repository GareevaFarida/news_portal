/**
 * Контроллер регитрации пользователя
 * @author
 * fix Dmitriy Ostrovskiy 18.03.2020
 * created on
 */

package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.services.UserService;
import ru.geek.news_portal.utils.SystemUser;

import javax.validation.Valid;

@Controller
//@RequestMapping("/register")
public class RegistrationController {
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/register")
  public String showMyLoginPage(Model model) {
    model.addAttribute("systemUser", new SystemUser());
    return "ui/register";
  }

//  @GetMapping("/forgot")
//  public String showMyForgotPage(Model model) {
//    model.addAttribute("systemUser", new SystemUser());
//    return "ui/forgot";
//  }


  @PostMapping("/register/process")
  public String processRegistrationForm(@ModelAttribute("systemUser")
                                          @Valid SystemUser systemUser,
                                        BindingResult bindingResult,
                                        Model model,
                                        final RedirectAttributes redirectAttributes) {
    String username = systemUser.getUsername();
    if (bindingResult.hasErrors()) {
      return "ui/register";
    }
    User existing = userService.findByUsername(username);
    if (existing != null) {
//      model.addAttribute("systemUser", systemUser);
      model.addAttribute("registrationError", "User with current username is already exist");
      return "ui/register";
    }
    userService.save(systemUser);
    return "redirect:/login";
  }

//  @PostMapping("/forgot/process")
//  public String processForgotUser(@ModelAttribute("systemUser")
//                                        @Valid SystemUser systemUser,
//                                        BindingResult bindingResult,
//                                        Model model,
//                                        final RedirectAttributes redirectAttributes) {
//    String username = systemUser.getEmail();
//    if (bindingResult.hasErrors()) {
//      return "ui/forgot";
//    }
//    User existing = userService.findByUsername(username);
//    if (existing != null) {
//      model.addAttribute("systemUser", systemUser);
//      model.addAttribute("forgotMessage", "Email Post");
//      return "ui/forgot";
//    }
//    return "redirect:/login";
//  }
}
