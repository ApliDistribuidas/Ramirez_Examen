package com.espe.micro_proyectos.services;

import com.espe.micro_proyectos.models.entities.Proyecto;
import com.espe.micro_proyectos.models.entities.ProyectosEmpleados;
import com.espe.micro_proyectos.repositories.ProyectoRepository;
import com.espe.micro_proyectos.repositories.ProyectosEmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectosEmpleadosServiceImpl implements ProyectosEmpleadosService {

    @Autowired
    private ProyectosEmpleadosRepository repository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public ProyectosEmpleados assignEmpleadoToProyecto(Long proyectoId, Long empleadoId) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        ProyectosEmpleados relacion = new ProyectosEmpleados();
        relacion.setProyecto(proyecto);
        relacion.setEmpleadoId(empleadoId);

        return repository.save(relacion);
    }

    @Override
    public List<ProyectosEmpleados> getEmpleadosByProyecto(Long proyectoId) {
        return repository.findByProyectoId(proyectoId);
    }

    @Override
    public List<ProyectosEmpleados> getProyectosByEmpleado(Long empleadoId) {
        return repository.findByEmpleadoId(empleadoId);
    }

    @Override
    public void removeEmpleadoFromProyecto(Long proyectoId, Long empleadoId) {
        List<ProyectosEmpleados> relaciones = repository.findByProyectoId(proyectoId);
        relaciones.stream()
                .filter(relacion -> relacion.getEmpleadoId().equals(empleadoId))
                .findFirst()
                .ifPresent(repository::delete);
    }
}
