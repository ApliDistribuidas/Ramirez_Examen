package com.espe.micro_proyectos.controllers;

import com.espe.micro_proyectos.models.entities.ProyectosEmpleados;
import com.espe.micro_proyectos.services.ProyectosEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos-empleados")
public class ProyectosEmpleadosController {

    @Autowired
    private ProyectosEmpleadosService service;

    // Asignar empleado a un proyecto
    @PostMapping("/{proyectoId}/empleados/{empleadoId}")
    public ResponseEntity<ProyectosEmpleados> assignEmpleadoToProyecto(@PathVariable Long proyectoId, @PathVariable Long empleadoId) {
        return ResponseEntity.ok(service.assignEmpleadoToProyecto(proyectoId, empleadoId));
    }

    // Obtener empleados por proyecto
    @GetMapping("/proyecto/{proyectoId}/empleados")
    public List<ProyectosEmpleados> getEmpleadosByProyecto(@PathVariable Long proyectoId) {
        return service.getEmpleadosByProyecto(proyectoId);
    }

    // Obtener proyectos por empleado
    @GetMapping("/empleado/{empleadoId}/proyectos")
    public List<ProyectosEmpleados> getProyectosByEmpleado(@PathVariable Long empleadoId) {
        return service.getProyectosByEmpleado(empleadoId);
    }

    // Eliminar empleado de un proyecto
    @DeleteMapping("/{proyectoId}/empleados/{empleadoId}")
    public ResponseEntity<Void> removeEmpleadoFromProyecto(@PathVariable Long proyectoId, @PathVariable Long empleadoId) {
        service.removeEmpleadoFromProyecto(proyectoId, empleadoId);
        return ResponseEntity.noContent().build();
    }
}
