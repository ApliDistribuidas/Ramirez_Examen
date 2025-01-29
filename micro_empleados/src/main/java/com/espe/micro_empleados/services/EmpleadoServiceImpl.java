package com.espe.micro_empleados.services;

import com.espe.micro_empleados.models.entities.Empleados;
import com.espe.micro_empleados.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public Empleados save(Empleados empleado) {
        return repository.save(empleado);
    }

    @Override
    public List<Empleados> findAll() {
        return repository.findAll();
    }

    @Override
    public Empleados findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}