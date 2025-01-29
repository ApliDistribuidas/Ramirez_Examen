package com.espe.micro_proyectos.services;

import com.espe.micro_proyectos.models.entities.Proyecto;
import com.espe.micro_proyectos.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository repository;

    @Override
    public Proyecto save(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    @Override
    public List<Proyecto> findAll() {
        return repository.findAll();
    }

    @Override
    public Proyecto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
