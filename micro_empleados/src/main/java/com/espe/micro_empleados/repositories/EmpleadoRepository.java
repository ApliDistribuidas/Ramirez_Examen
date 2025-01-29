package com.espe.micro_empleados.repositories;

import com.espe.micro_empleados.models.entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {
}