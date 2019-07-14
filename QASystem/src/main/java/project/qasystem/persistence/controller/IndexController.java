package project.qasystem.persistence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

public class IndexController {

    @ModelAttribute("userIsLoggedIn")
    public String userIsLoggedIn(Principal principal) {
        if(principal.getName() != null) {
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login_page";
    }

}
