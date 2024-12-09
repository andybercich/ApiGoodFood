package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Caudatta.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController extends BaseController<Sucursal, Long> {

    @Autowired
    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        super(sucursalService);
    }

    @GetMapping("/empresa/{id}")
    public List<Sucursal> getByEmpresaId(@PathVariable("id") Long idEmpresa) throws Exception {
        return sucursalService.findAllByEmpresaId(idEmpresa);
    }

}
