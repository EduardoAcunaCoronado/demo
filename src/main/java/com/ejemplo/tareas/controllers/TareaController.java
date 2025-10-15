package com.ejemplo.tareas.controllers;

import com.ejemplo.tareas.models.Tarea;
import com.ejemplo.tareas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Listar todas las tareas
    @GetMapping
    public ResponseEntity<List<Tarea>> listar() {
        return ResponseEntity.ok(tareaService.listarTareas());
    }

    // Agregar una nueva tarea
    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Tarea nuevaTarea) {
        Tarea creada = tareaService.agregarTarea(nuevaTarea);
        return ResponseEntity.status(201).body(creada);
    }


    // Marcar tarea como completada
    @PutMapping("/{id}/completar")
    public ResponseEntity<?> completar(@PathVariable int id) {
        return tareaService.completarTarea(id)
                .map(t -> ResponseEntity.ok("Tarea marcada como completada ✅"))
                .orElse(ResponseEntity.status(404).body("Tarea no encontrada"));
    }

    // Eliminar tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        boolean eliminada = tareaService.eliminarTarea(id);
        if (eliminada) {
            return ResponseEntity.ok("Tarea eliminada correctamente 🗑️");
        } else {
            return ResponseEntity.status(404).body("Tarea no encontrada");
        }
    }

    // Buscar tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable int id) {
        return tareaService.buscarTareaPorId(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Tarea no encontrada"));
    }

}
