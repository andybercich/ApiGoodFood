package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Factura;
import com.example.miPrimeraApi.Betha.repositories.FacturaRepository;
import com.example.miPrimeraApi.Caudatta.services.BaseService;
import com.example.miPrimeraApi.Caudatta.services.FacturaService;
import com.example.miPrimeraApi.Caudatta.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facturas")
public class FacturaController  extends BaseController<Factura,Long>{
    @Autowired
    private PedidoService facturaService;
    public FacturaController(FacturaService service) {
        super(service);
    }

}
