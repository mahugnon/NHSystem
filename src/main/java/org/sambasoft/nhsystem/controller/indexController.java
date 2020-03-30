package org.sambasoft.nhsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/login")
    public String showLoginForm(){
        return "view/loginForm";
    }

}
