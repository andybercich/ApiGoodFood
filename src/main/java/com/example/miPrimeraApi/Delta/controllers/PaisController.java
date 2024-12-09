package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Pais;
import com.example.miPrimeraApi.Caudatta.services.PaisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController extends BaseController<Pais, Long> {

    public PaisController(PaisService paisService){
        super(paisService);
    }

}
