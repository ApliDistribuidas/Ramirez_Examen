package com.espe.micro_empleados.controllers;

import com.espe.micro_empleados.models.entities.Empleados;
import com.espe.micro_empleados.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @PostMapping
    public ResponseEntity<Empleados> create(@Valid @RequestBody Empleados empleado) {
        return ResponseEntity.ok(service.save(empleado));
    }

    @GetMapping
    public List<Empleados> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleados> findById(@PathVariable Long id) {
        Empleados empleado = service.findById(id);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleados> update(@PathVariable Long id, @Valid @RequestBody Empleados empleado) {
        Empleados existingEmpleado = service.findById(id);

        if (existingEmpleado == null) {
            return ResponseEntity.notFound().build();
        }

        existingEmpleado.setNombre(empleado.getNombre());
        existingEmpleado.setEmail(empleado.getEmail());
        existingEmpleado.setPuesto(empleado.getPuesto());
        existingEmpleado.setFechaContratacion(empleado.getFechaContratacion());

        Empleados updatedEmpleado = service.save(existingEmpleado);

        return ResponseEntity.ok(updatedEmpleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}