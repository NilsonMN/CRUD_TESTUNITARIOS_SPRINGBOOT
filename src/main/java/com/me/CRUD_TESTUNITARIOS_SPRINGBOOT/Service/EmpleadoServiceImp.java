package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.Service;

import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.exception.NotFoundException;
import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.interfaces.EmpleadoRepository;
import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {

        Optional<Empleado> nuevoEmpleado = empleadoRepository.findByCorreo(empleado.getCorreo());
        if (nuevoEmpleado.isPresent()) {
            throw new NotFoundException("Ya existe un usario con ese correo: " + empleado.getCorreo());
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado update(Empleado empleado) {

        Optional<Empleado> actualizarEmpleado = empleadoRepository.findByCorreo(empleado.getCorreo());
        if (!actualizarEmpleado.isPresent()) {
            throw new NotFoundException("No exite un empleado con email: " + empleado.getCorreo());
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }
}
