package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Provincia;
import com.example.miPrimeraApi.Caudatta.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController extends BaseController<Provincia, Long> {

    @Autowired
    private ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService){
        super(provinciaService);
    }


    @GetMapping("/pais/{idPais}")
    public List<Provincia> getByIdPais(@PathVariable("idPais") Long idPais) throws Exception {

        return provinciaService.getAllByPaisId(idPais);

    }
}
