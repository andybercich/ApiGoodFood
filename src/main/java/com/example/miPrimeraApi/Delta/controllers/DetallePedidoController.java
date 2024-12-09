package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.DetallePedido;
import com.example.miPrimeraApi.Caudatta.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detallePedidos")
public class DetallePedidoController extends BaseController<DetallePedido, Long> {

    @Autowired
    private DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService){
        super(detallePedidoService);
    }

    @GetMapping("/pedido/{id}")
    public List<DetallePedido> getByPedidoId(@PathVariable("id") Long idPedido) throws Exception {
        List<DetallePedido> detallePedidos = detallePedidoService.listarByPedido(idPedido);
        return detallePedidos;
    }

    @GetMapping("/articulo/{id}")
    public List<DetallePedido> getByArticuloId(@PathVariable("id") long idArticulo) throws Exception {

        return detallePedidoService.listarByArticulo(idArticulo);
    }



}
