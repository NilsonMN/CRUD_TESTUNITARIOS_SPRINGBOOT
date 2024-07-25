package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.repository;

import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.interfaces.EmpleadoRepository;
import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.model.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    void saveEmpleado(){
        Empleado empleado = Empleado.builder()
                .correo("e1@gmail.com")
                .nombre("Camilo")
                .salario(900.0)
                .build();
        Empleado empleado1 = empleadoRepository.save(empleado);

        assertThat(empleado1.getCorreo()).isEqualTo("e1@gmail.com");
        assertThat(empleado1.getNombre()).isEqualTo("Camilo");
        assertThat(empleado1.getSalario()).isEqualTo(900);
        assertThat(empleado1.getId()).isGreaterThan(0);
    }

    @Test
    void actualizarEmpleado(){
        Empleado empleado = Empleado.builder()
                .correo("e1@gmail.com")
                .nombre("Camilo")
                .salario(900.0)
                .build();
        Empleado empleado1 = empleadoRepository.save(empleado);

        empleado1.setNombre("Javier");
        empleado1.setSalario(2500.0);
        Empleado empleadoActualizado = empleadoRepository.save(empleado1);

        assertThat(empleadoActualizado.getNombre()).isEqualTo("Javier");
        assertThat(empleadoActualizado.getSalario()).isEqualTo(2500);
    }
}
