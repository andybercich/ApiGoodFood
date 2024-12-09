package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.PromocionDetalle;
import com.example.miPrimeraApi.Caudatta.services.PromocionDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promocionDetalle")
public class PromocionDetalleController extends BaseController<PromocionDetalle, Long> {
    @Autowired
    private PromocionDetalleService promocionDetalleService;

    public PromocionDetalleController(PromocionDetalleService promocionDetalleService){
        super(promocionDetalleService);
    }

    @GetMapping("/promocion/{id}")
    public List<PromocionDetalle> getByIdPromocion(@PathVariable("id") Long idPromocion) throws Exception {
        return promocionDetalleService.getAllByIdPromocion(idPromocion);
    }

    @GetMapping("/articulo/{id}")
    public List<PromocionDetalle> getByIdArticulo(@PathVariable("id") Long idArticulo) throws Exception {
        return promocionDetalleService.getAllByIdArticulo(idArticulo);
    }

}
