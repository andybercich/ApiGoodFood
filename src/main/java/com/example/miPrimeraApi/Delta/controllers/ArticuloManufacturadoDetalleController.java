package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturadoDetalle;
import com.example.miPrimeraApi.Caudatta.services.ArticuloManufacturadoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articuloManufacturadoDetalle")
public class ArticuloManufacturadoDetalleController extends BaseController<ArticuloManufacturadoDetalle, Long> {

    @Autowired
    private ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService;

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService){
        super(articuloManufacturadoDetalleService);
    }
    @GetMapping("/articuloInsumo/{id}")
    public List<ArticuloManufacturadoDetalle> getByIdArticuloInsumo(@PathVariable("id") Long idInsumo) throws Exception {

        return articuloManufacturadoDetalleService.getAllByArticuloInsumoId(idInsumo);

    }

    @GetMapping("/articuloManufacturado/{id}")
    public List<ArticuloManufacturadoDetalle> getByIdArticuloManufacturado(@PathVariable("id") Long idManufacturado) throws Exception {

        return articuloManufacturadoDetalleService.getAllByArticuloManufacturadoId(idManufacturado);

    }
}
