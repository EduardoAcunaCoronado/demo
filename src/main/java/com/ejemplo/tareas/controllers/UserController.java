package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Andrés", "Guzmán",  null);
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/details-map")
    public String details(Map<String, Object> model) {
        User user = new User("Andrés Map", "Guzmán Map",  "email@map.map");
        model.put("title", "Hola Mundo Spring Boot Map");
        model.put("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Lista de Usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return List.of(
            new User("Andrés", "Guzmán", "andres.guzman@gmail.com"),
            new User("María", "López", "maria.lopez@gmail.com"),
            new User("Carlos", "Pérez", "carlos.perez@gmail.com")
        );
    }

    @ModelAttribute("usersEmpty")
    public List<User> usersEmptyModel() {
        return List.of();
    }
}
