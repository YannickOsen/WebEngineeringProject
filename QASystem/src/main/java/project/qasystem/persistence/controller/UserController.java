package project.qasystem.persistence.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
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

@Controller
//@RequestMapping("/user")
public class UserController {

    private UserService userService = new UserService();


    @ModelAttribute("registration")
    public RegistrationDto registrationDto() {
        return new RegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        RegistrationDto registrationDto = registrationDto();
        model.addAttribute("registration", new RegistrationDto());
        return "register";
    }

    @GetMapping("/testpage")
    public String testPage(){
        return "testPage";
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

    @RequestMapping("/logout")
    public String logout() {
        return "welcome";
    }

    @RequestMapping("/questionlist")
    public String questionList() {
        return "questionList";
    }

    @RequestMapping("/question")
    public String question() {
        return "question";
    }

    @RequestMapping("/newquestion")
    public String newQuestion() {
        return "newQuestion";
    }

    /**
     * Brings the User to the registration page.
     *
     *
     * @return "user_startup_page" to navigate to the page.
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("registration") RegistrationDto registrationDto, BindingResult result) {
/*      registrationDto.setUserName(username);
        registrationDto.setPassword(password);
        registrationDto.setConfirmPassword(confirmPassword);*/
        if (result.hasErrors()) {
            return "register";
        }
        System.out.println(registrationDto.getUserName());
//        registrationDto.userNameTest();
        String error = userService.checkToCreateUser(registrationDto);
       if (error == "") {
           userService.createUser(registrationDto.getUserName(), registrationDto.getPassword());
           return "redirect:welcome";
       }
       return "register";
    }


    //TODO add user:Post

}
