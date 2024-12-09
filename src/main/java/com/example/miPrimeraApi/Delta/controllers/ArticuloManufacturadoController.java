package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturado;
import com.example.miPrimeraApi.Caudatta.services.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articuloManufacturado")
public class ArticuloManufacturadoController extends BaseController<ArticuloManufacturado, Long> {

    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;

    public ArticuloManufacturadoController(ArticuloManufacturadoService articuloManufacturadoService){
        super(articuloManufacturadoService);
    }

    @GetMapping("/categoria/{id}")
    public List<ArticuloManufacturado> getAllByCategoriaId(@PathVariable("id") Long idCategoria) throws Exception {
        return articuloManufacturadoService.getAllByCategoriaId(idCategoria);
    }

    @GetMapping("/unidadMedida/{id}")
    public List<ArticuloManufacturado> getAllByUnidadMedidaId(@PathVariable("id") Long idUnidadMedida) throws Exception {
        return articuloManufacturadoService.getAllByCategoriaId(idUnidadMedida);
    }

}
