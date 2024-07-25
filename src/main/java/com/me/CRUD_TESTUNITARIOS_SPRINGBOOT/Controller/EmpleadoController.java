package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.Controller;

import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.Service.EmpleadoServiceImp;
import com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImp empleadoServiceImp;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado save(@RequestBody Empleado empleado) {
        return empleadoServiceImp.save(empleado);
    }

    @GetMapping
    public List<Empleado> list() {
        return empleadoServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") Long id) {
        return empleadoServiceImp.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable("id") Long id, @RequestBody Empleado empleado) {
        return empleadoServiceImp.getById(id)
                .map(empleadoEncontrado -> {
                    empleadoEncontrado.setNombre(empleado.getNombre());
                    empleadoEncontrado.setCorreo(empleado.getCorreo());
                    empleadoEncontrado.setSalario(empleado.getSalario());

                    Empleado empleadoActualizado = empleadoServiceImp.update(empleadoEncontrado);
                    return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        empleadoServiceImp.delete(id);
        return new ResponseEntity<>("Empleado eliminado", HttpStatus.OK);
    }
}
