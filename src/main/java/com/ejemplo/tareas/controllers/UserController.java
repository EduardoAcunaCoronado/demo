package com.ejemplo.tareas.controllers;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("name", "Andrés");
        model.addAttribute("lastname", "Guzmán");
        return "details";
    }

    @GetMapping("/details/map")
    public String details(Map<String, Object> model) {
        model.put("title", "Hola Mundo Spring Boot Map");
        model.put("name", "Andrés Map");
        model.put("lastname", "Guzmán Map");
        return "details";
    }

}
