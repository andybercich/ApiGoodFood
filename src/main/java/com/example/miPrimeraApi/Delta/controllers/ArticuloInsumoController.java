package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.ArticuloInsumo;
import com.example.miPrimeraApi.Caudatta.services.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articuloInsumo")
public class ArticuloInsumoController extends BaseController<ArticuloInsumo, Long> {
    @Autowired
    private ArticuloInsumoService articuloInsumoService;

    public ArticuloInsumoController(ArticuloInsumoService articuloInsumoService){
        super(articuloInsumoService);
    }

    @GetMapping("/categoria/{id}")
    public List<ArticuloInsumo> getAllByCategoriaId(@PathVariable("id") Long idCategoria) throws Exception {
        return articuloInsumoService.getAllByCategoriaId(idCategoria);
    }

    @GetMapping("/unidadMedida/{id}")
    public List<ArticuloInsumo> getAllByUnidadMedidaId(@PathVariable("id") Long idUnidadMedida) throws Exception {
        return articuloInsumoService.getAllByCategoriaId(idUnidadMedida);
    }
}
