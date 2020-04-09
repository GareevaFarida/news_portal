package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.RoleRepository;
import ru.geek.news_portal.services.UserService;
import ru.geek.news_portal.utils.SystemUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 05.04.2020
 * @link https://github.com/Centnerman
 */

// Работаем с пользователями имея правами админа -------------------------------------------

@Controller
public class AdminUserController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public AdminUserController(RoleRepository roleRepository,
                               UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    //---------------------------------------------------------------------------

    @GetMapping({"/admin/users", "/users"})
    public String adminUsersPage(Model model, HttpServletRequest request) {
        if (!request.isUserInRole("ADMIN")) {
            return "redirect:/";
        }
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "users";
    }

//    @GetMapping({"/user/edituser", "/user/edituser/{username}"})
//    public String adminEditUser(Model model, @PathVariable(value = "username", required = false) String username,
//                                HttpServletRequest request) {
//        if (!request.isRequestedSessionIdValid()) {
//            return "redirect:/";
//        }
//        model.addAttribute("edit", true);
//        model.addAttribute("activePage", "Users");
//        model.addAttribute("user", userService.findByUsername(username));
//        model.addAttribute("roles", roleRepository.findAll());
//        return "users";
//    }


    @GetMapping("/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "users";
    }

    @PostMapping("/user/update")
    public String updateUser(@Valid @ModelAttribute("systemUser") SystemUser systemUser,
                             BindingResult bindingResult, Model model) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "users";
        }

        userService.update(systemUser);
        return "users";
    }

    @GetMapping("/user/delete/{id}")
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
