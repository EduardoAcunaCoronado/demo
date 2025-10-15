package com.ejemplo.tareas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String decirHola() {
        return "¡Hola desde Spring Boot!";
    }
}
