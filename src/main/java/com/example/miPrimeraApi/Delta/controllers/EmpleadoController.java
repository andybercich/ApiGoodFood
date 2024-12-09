package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Empleado;
import com.example.miPrimeraApi.Caudatta.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends BaseController<Empleado, Long> {

    @Autowired
    private EmpleadoService empleadoService;


    public EmpleadoController(EmpleadoService empleadoService){
        super(empleadoService);
    }


    @GetMapping("/sucursal/{idSucursal}")
    public List<Empleado> getAllBySucursalId(@PathVariable("idSucursal") Long idSucursal) throws Exception {

        return empleadoService.getAllBySucursalId(idSucursal);

    }
}
