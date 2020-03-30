package org.sambasoft.nhsystem.controller;

import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/register")
    public String registerForm(Model model){
        model.addAttribute("user",new User());
        return "view/registerForm";
    }
    @PostMapping(path = "/register")
    public  String registerUser(@Valid User user, BindingResult bindingResult, Model model){
    if(bindingResult.hasErrors()) return "view/registerForm";

   if ( userService.isUserPresent(user.getEmail()) ){
       model.addAttribute("exist",true);
       return "view/registerForm";
   }
    userService.createUser(user);
        return "view/success";
    }
}
