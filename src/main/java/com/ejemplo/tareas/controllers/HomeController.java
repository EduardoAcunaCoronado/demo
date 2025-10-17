package com.ejemplo.tareas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/"})
    public String homeRedirect() {
        return "redirect:/list";
    }

    @GetMapping({ "/home"})
    public String homeForward() {
        return "forward:/list";
    }

}
