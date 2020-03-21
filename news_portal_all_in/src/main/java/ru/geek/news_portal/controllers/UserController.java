package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.RoleRepository;
import ru.geek.news_portal.services.UserService;
import ru.geek.news_portal.utils.SystemUser;

import javax.validation.Valid;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.03.2020
 * @link https://github.com/Centnerman
 */

@Controller
public class UserController {
    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public UserController(RoleRepository roleRepository,
                          UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @GetMapping("/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @PostMapping("/user")
    public String adminUpsertUser(@Valid User user, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "user_form";
        }

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}/delete")
    public String adminDeleteUser(Model model, @PathVariable("id") Long id) {
        userService.delete(id);
        return "users";
    }

    @GetMapping("/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        return "index";
    }
}
