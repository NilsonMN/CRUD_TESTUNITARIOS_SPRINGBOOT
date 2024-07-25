package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.Service;

import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Empleado save(Empleado empleado);
    List<Empleado> getAll();
    Optional<Empleado> getById(Long id);
    Empleado update(Empleado empleado);
    void delete(Long id);
}
