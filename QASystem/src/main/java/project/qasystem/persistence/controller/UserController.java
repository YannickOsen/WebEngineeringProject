package project.qasystem.persistence.controller;


import org.springframework.validation.BindingResult;
import project.qasystem.persistence.DTOs.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.DTOs.UserDto;
import project.qasystem.persistence.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("registration")
    public RegistrationDto registrationDto() {
        return new RegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model, Principal principal) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        model.addAttribute("registration", registrationDto());
        return "register";
    }

    /**
     * Brings the User to the Startup page.
     *
     *
     * @return "user_startup_page" to navigate to the page.
     */
    @RequestMapping("/home")
    public String startUp(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "welcome"; }

    @RequestMapping("/")
    public String welcome(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "welcome"; }

    @RequestMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "signin";
    }

    @RequestMapping("/login_successful")
    public String loginSuccess(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "welcome";
    }

    @RequestMapping("/registration_successful")
    public String registrationSuccess(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "welcome";
    }

    @RequestMapping("/logout_successful")
    public String logoutSuccess(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "signin";
    }

    @RequestMapping("/questionlist")
    public String questionList(Principal principal, Model model) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "questionList";
    }

    @RequestMapping("/question")
    public String question() {
        return "question";
    }

    /**
     * Brings the User to the registration page.
     *
     *
     * @return "user_startup_page" to navigate to the page.
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("registration") RegistrationDto registrationDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        String error = userService.checkToCreateUser(registrationDto);
        model.addAttribute("allUser", userService.getAllUsers());
        if (error == "") {
            return "redirect:/registration_successful";
        }
        return "register";
    }



}
