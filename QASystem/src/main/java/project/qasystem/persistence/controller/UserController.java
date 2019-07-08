package project.qasystem.persistence.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.WebRequest;
import project.qasystem.persistence.DTOs.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.Service.UserService;

import javax.validation.Valid;

//TODO maybe remove url if a user mapping is not beneficial as userpages are not necessary
@Controller
//@RequestMapping("/user")
public class UserController {

    private UserService userService = new UserService();


    @ModelAttribute("user")
    public RegistrationDto registrationDto() {
        return new RegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        RegistrationDto registrationDto = registrationDto();
        model.addAttribute("user", registrationDto);
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
    public String login() {
        return "signin";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "welcome";
    }

    /**
     * Brings the User to the registration page.
     *
     *
     * @return "user_startup_page" to navigate to the page.
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") RegistrationDto registrationDto, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        System.out.println(registrationDto.getUserName());
        registrationDto.userNameTest();
        String error = userService.checkToCreateUser(registrationDto);
       if (error == "") {
           userService.createUser(registrationDto.getUserName(), registrationDto.getPassword());
           return "welcome";
       }
       return "register";
    }


    //TODO add user:Post

}
