package project.qasystem.persistence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login_page";
    }


    @GetMapping("/testpage")
    public String testPage(){
        return "testPage";
    }
}
