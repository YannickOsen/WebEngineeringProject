package project.qasystem.persistence.controller;


import org.springframework.validation.BindingResult;
import project.qasystem.persistence.DTOs.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.service.UserService;

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
    public String showRegistrationForm(Model model) {
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
    //TODO create startup page for user
    public String startUp() { return "welcome"; }

    @RequestMapping("/")
    //TODO create startup page for user
    public String welcome() { return "welcome"; }

    @RequestMapping("/login")
    public String login() {
        return "signin";
    }

    @RequestMapping("/login_successful")
    public String loginSuccess() {
        return "welcome";
    }

    @RequestMapping("/registration_successful")
    public String registrationSuccess() {
        return "welcome";
    }

    @RequestMapping("/logout_successful")
    public String logoutSuccess() {
        return "signin";
    }

    @RequestMapping("/questionlist")
    public String questionList() {
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


    //TODO add user:Post

}
