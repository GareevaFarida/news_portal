package ru.geek.news_portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.base.repo.RoleRepository;
import ru.geek.news_portal.dto.UserSimpleDTO;
import ru.geek.news_portal.services.UserService;
import ru.geek.news_portal.utils.SystemUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * GeekBrains Java, news_portal.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 21.03.2020
 * @link https://github.com/Centnerman
 * fix Dmitriy Ostrovskiy
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public UserController(RoleRepository roleRepository,
                          UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/edituser", "/user/edituser/{username}"})
    public String adminEditUser(Model model, @PathVariable(value = "username", required = false) String username,
                                HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("edit", true);
//        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("roles", roleRepository.findAll());
        return "ui/personal";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/favorite", "/user/favorite/{username}"})
    public String userFavorites(Model model, @PathVariable(value = "username", required = false) String username,
                                HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/user_favorites";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/comment", "/user/comment/{username}"})
    public String userComments(Model model, @PathVariable(value = "username", required = false) String username,
                               HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/user_comments";
    }

    //-------------------------------------------------------------------------------
    // Работает через жопу (дополнительный класс) без проверки на ошибки.
    // todo Нужно исправить изменение пароля и добавить контроль неправильного ввода
    //-------------------------------------------------------------------------------
    @GetMapping({"/user/change_password", "/user/change_password/{username}"})
    public String userChangePasswordGet(
            @PathVariable(value = "username", required = false) String username,
            Model model,
            HttpServletRequest request) {

        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }

        UserSimpleDTO userSimpleDTO = new UserSimpleDTO();
        userSimpleDTO.setUsername(userService.findByUsername(username).getUsername());
        userSimpleDTO.setPassword(userService.findByUsername(username).getPassword());

        model.addAttribute("userSimpleDTO", userSimpleDTO);
        return "ui/resetpass";
    }

    @PostMapping("/user/change_password")
    public String userChangePasswordPost(
            @Valid @ModelAttribute("userSimpleDTO") UserSimpleDTO userSimpleDTO,
            BindingResult bindingResult,
            Model model) {

        User user = userService.findByUsername(userSimpleDTO.getUsername());
        userService.updatePass(user, userSimpleDTO.getPassword());
        return "redirect:/";
    }

    //-------------------------------------------------------------------------------

    @GetMapping({"/user/setting", "/user/setting/{username}"})
    public String userSettings(Model model, @PathVariable(value = "username", required = false) String username,
                               HttpServletRequest request) {
        if (!request.isRequestedSessionIdValid()) {
            return "redirect:/";
        }
        model.addAttribute("user", userService.findByUsername(username));
        return "ui/settings";
    }

    //-------------------------------------------------------------------------------
}
