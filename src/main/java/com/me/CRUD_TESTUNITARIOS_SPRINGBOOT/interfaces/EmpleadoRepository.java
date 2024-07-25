package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.interfaces;

import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByCorreo(String correo);
}
