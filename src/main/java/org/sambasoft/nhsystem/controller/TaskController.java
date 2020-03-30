package org.sambasoft.nhsystem.controller;

import org.sambasoft.nhsystem.entities.Task;
import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.services.TaskService;
import org.sambasoft.nhsystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {
    TaskService taskService;
    UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession httpSession){
        httpSession.setAttribute("email",email);
        model.addAttribute("task",new Task());
        return "view/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult,HttpSession httpSession){
        if(bindingResult.hasErrors()) return "view/taskForm";
    String email = (String) httpSession.getAttribute("email");
User user=userService.findOne(email);
if(user==null) throw  new NullPointerException("user" +email+" not found");
    taskService.addTask(task,user);
        return "redirect:/users";
    }
}
