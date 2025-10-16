package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Andrés", "Guzmán");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/details/map")
    public String details(Map<String, Object> model) {
        User user = new User("Andrés Map", "Guzmán Map");
        model.put("title", "Hola Mundo Spring Boot Map");
        model.put("user", user);
        return "details";
    }

}
