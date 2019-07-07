package project.qasystem.persistence.controller;

import project.qasystem.persistence.DTOs.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.Service.UserService;

//TODO maybe remove url if a user mapping is not beneficial as userpages are not necessary
@Controller
//@RequestMapping("/user")
public class UserController {


    @ModelAttribute("user")
    public RegistrationDto registrationDto() {
        return new RegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
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
    public String startUp() { return "user_startup_page"; }

    @RequestMapping("/")
    //TODO create startup page for user
    public String welcome() { return "welcome"; }

    @RequestMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "signin";
    }

    /**
     * Brings the User to the registration page.
     *
     *
     * @return "user_startup_page" to navigate to the page.
     */
    @RequestMapping("/registration")
    //TODO create registration page for user
    public String registration() { return "register"; }


    //TODO add user:Post

}
