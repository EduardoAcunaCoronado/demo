package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.dto.ParamResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ResponseEntity<ParamResponse> foo(@RequestParam(required = false, defaultValue = "Hola que tal", name = "mensaje") String message){
        ParamResponse paramResponse = new ParamResponse();
        paramResponse.setMessage(message);
        return ResponseEntity.ok(paramResponse);
    }

    @GetMapping("/bar")
    public ResponseEntity<ParamResponse> bar(@RequestParam String text, @RequestParam Integer code){
        ParamResponse paramResponse = new ParamResponse();
        paramResponse.setMessage(text);
        paramResponse.setCode(code);
        return ResponseEntity.ok(paramResponse);
    }

    @GetMapping("/request")
    public ResponseEntity<ParamResponse> request(HttpServletRequest request){
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        ParamResponse paramResponse = new ParamResponse();
        paramResponse.setMessage(request.getParameter("message"));
        paramResponse.setCode(code);
        return ResponseEntity.ok(paramResponse);
    }

}
