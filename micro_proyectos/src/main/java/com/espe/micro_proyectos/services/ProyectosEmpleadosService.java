package com.espe.micro_proyectos.services;

import com.espe.micro_proyectos.models.entities.ProyectosEmpleados;
import java.util.List;

public interface ProyectosEmpleadosService {
    ProyectosEmpleados assignEmpleadoToProyecto(Long proyectoId, Long empleadoId);  // Cambio aquí, debe devolver ProyectosEmpleados, no ProyectoService
    List<ProyectosEmpleados> getEmpleadosByProyecto(Long proyectoId);
    List<ProyectosEmpleados> getProyectosByEmpleado(Long empleadoId);
    void removeEmpleadoFromProyecto(Long proyectoId, Long empleadoId);
}
