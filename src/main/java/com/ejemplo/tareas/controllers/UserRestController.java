package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.dto.UserResponse;
import com.ejemplo.tareas.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public ResponseEntity<UserResponse> details() {
        UserResponse userResponse = new UserResponse();
        User user = new User("Andrés", "Guzmán");
        userResponse.setUser(user);
        userResponse.setTitle("Hola Mundo Spring Boot");
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>>list() {
        List<User> users =List.of(
            new User("Andrés", "Guzmán"),
            new User("María", "López"),
            new User("Carlos", "Pérez")
        );
        return ResponseEntity.ok(users);
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Andrés", "Guzmán");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot Map");
        body.put("user", user);

        return body;
    }

}
