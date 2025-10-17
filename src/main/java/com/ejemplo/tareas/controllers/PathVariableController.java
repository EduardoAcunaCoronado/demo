package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.dto.ParamResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.code}")
    private String code;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.description}")
    private String description;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

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

    @GetMapping("/values")
    public Map<String, Object> getValues(@Value("${config.message}") String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",  username);
        map.put("code", code);
        map.put("message", message);
        map.put("listOfValues", listOfValues);
        map.put("valueList", valueList);
        map.put("valueString", valueString);
        map.put("valuesMap", valuesMap);
        map.put("product", product);
        map.put("description", description);
        map.put("price", price);
        return map;
    }

}
