package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Localidad;
import com.example.miPrimeraApi.Caudatta.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController extends BaseController<Localidad, Long> {
    @Autowired
    private LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService){
        super(localidadService);
    }

    @GetMapping("/provincia/{idProvincia}")
    public List<Localidad> getAllByProvinciaId(@PathVariable ("idProvincia") Long idProvincia) throws Exception {

        return localidadService.getAllByProvinciaId(idProvincia);
    }
}
