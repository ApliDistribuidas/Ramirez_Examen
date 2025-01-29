package com.espe.micro_empleados.services;

import com.espe.micro_empleados.models.entities.Empleados;
import java.util.List;

public interface EmpleadoService {
    Empleados save(Empleados empleado);
    List<Empleados> findAll();
    Empleados findById(Long id);
    void deleteById(Long id);
}
