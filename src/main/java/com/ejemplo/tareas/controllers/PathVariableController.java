package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.dto.ParamResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ResponseEntity<ParamResponse> baz(@PathVariable String message) {
        ParamResponse paramResponse = new ParamResponse();
        paramResponse.setMessage(message);
        paramResponse.setCode(200);
        return ResponseEntity.ok(paramResponse);
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("id", id);
        return map;
    }

}
