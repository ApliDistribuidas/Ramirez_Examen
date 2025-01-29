package com.espe.micro_proyectos.repositories;

import com.espe.micro_proyectos.models.entities.ProyectosEmpleados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectosEmpleadosRepository extends JpaRepository<ProyectosEmpleados, Long> {
    List<ProyectosEmpleados> findByProyectoId(Long proyectoId);

    List<ProyectosEmpleados> findByEmpleadoId(Long empleadoId);
}
