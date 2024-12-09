package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Empresa;
import com.example.miPrimeraApi.Caudatta.services.EmpresaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController extends BaseController<Empresa, Long> {

    public EmpresaController(EmpresaService empresaService){
        super(empresaService);
    }

}
