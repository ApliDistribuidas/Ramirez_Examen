package com.espe.micro_proyectos.controllers;

import com.espe.micro_proyectos.models.entities.Proyecto;
import com.espe.micro_proyectos.services.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService service;

    // Crear nuevo proyecto
    @PostMapping
    public ResponseEntity<Proyecto> create(@Valid @RequestBody Proyecto proyecto) {
        Proyecto savedProyecto = service.save(proyecto);
        return ResponseEntity.ok(savedProyecto);
    }

    // Obtener todos los proyectos
    @GetMapping
    public List<Proyecto> findAll() {
        return service.findAll();
    }

    // Obtener proyecto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> findById(@PathVariable Long id) {
        Proyecto proyecto = service.findById(id);
        return proyecto != null ? ResponseEntity.ok(proyecto) : ResponseEntity.notFound().build();
    }

    // Eliminar proyecto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar proyecto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> update(@PathVariable Long id, @Valid @RequestBody Proyecto proyecto) {
        Proyecto existingProyecto = service.findById(id);
        if (existingProyecto != null) {
            proyecto.setId(id);  // Asigna el ID del proyecto existente para la actualización
            Proyecto updatedProyecto = service.save(proyecto);
            return ResponseEntity.ok(updatedProyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
