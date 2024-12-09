package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.UnidadMedida;
import com.example.miPrimeraApi.Caudatta.services.UnidadMedidaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidadMedida")
public class UnidadMedidaController extends BaseController<UnidadMedida, Long> {

    public UnidadMedidaController(UnidadMedidaService unidadMedidaService){
        super(unidadMedidaService);
    }

}
