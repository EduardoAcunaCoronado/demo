package com.ejemplo.tareas.services;

import com.ejemplo.tareas.components.IdGenerator;
import com.ejemplo.tareas.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final List<Tarea> tareas = new ArrayList<>();

    @Autowired
    private IdGenerator idGenerator;

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public Tarea agregarTarea(Tarea tarea) {
        tarea.setId(idGenerator.siguienteId());
        tareas.add(tarea);
        return tarea;
    }

    public Optional<Tarea> buscarTareaPorId(int id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst();
    }

    public Optional<Tarea> completarTarea(int id) {
        return buscarTareaPorId(id).map(t -> {
            t.setCompletada(true);
            return t;
        });
    }

    public boolean eliminarTarea(int id) {
        return tareas.removeIf(t -> t.getId() == id);
    }
}
