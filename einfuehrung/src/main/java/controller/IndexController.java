package controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login_page";
    }
}
