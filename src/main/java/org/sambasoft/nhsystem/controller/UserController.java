package org.sambasoft.nhsystem.controller;

import org.sambasoft.nhsystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@GetMapping(path = "/users")
    public  String listUsers(Model model, @RequestParam(defaultValue = "",name = "name") String name){
        model.addAttribute("users",userService.findByName(name));
        model.addAttribute("searched",name);
        return "view/list";
    }
}
