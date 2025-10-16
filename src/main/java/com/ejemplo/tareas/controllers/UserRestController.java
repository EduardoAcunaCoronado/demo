package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Andrés", "Guzmán");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot Map");
        body.put("user", user);

        return body;
    }

}
