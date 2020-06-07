package org.moren.spring.controller;

import org.moren.spring.model.User;
import org.moren.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult,
                          Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        } else if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passNotEquals", "passwords isn't equals");
            return "registration";
        } else if (!userService.save(user)){
            model.addAttribute("usernameError", "A user with the same name already exists.");
            return "registration";
        }

        return "redirect:/";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
