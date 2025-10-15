package com.ejemplo.tareas.components;

import org.springframework.stereotype.Component;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IdGenerator {
    private final AtomicInteger contador = new AtomicInteger(1);

    public int siguienteId() {
        return contador.getAndIncrement();
    }
}
