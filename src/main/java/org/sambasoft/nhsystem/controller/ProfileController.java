package org.sambasoft.nhsystem.controller;

import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.services.TaskService;
import org.sambasoft.nhsystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    UserService userService;
    TaskService taskService;

    public ProfileController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping(path = "/profile")
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks",taskService.findUserTask(user));
        return "view/profile";
    }
}
