package com.espe.micro_proyectos.services;

import com.espe.micro_proyectos.models.entities.Proyecto;

import java.util.List;

public interface ProyectoService {
    Proyecto save(Proyecto proyecto);
    List<Proyecto> findAll();
    Proyecto findById(Long id);
    void deleteById(Long id);
}
