package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Factura;
import com.example.miPrimeraApi.Alpha.entities.Pedido;
import com.example.miPrimeraApi.Caudatta.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseController<Pedido, Long> {

    @Autowired
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        super(pedidoService);
    }

    @PutMapping("/total")
    public Optional<Pedido> calcularTotal(@RequestBody Pedido pedido) throws Exception {
        Pedido pedido_aux = pedidoService.calcularTotal(pedido);
        return Optional.ofNullable(pedido_aux);
    }

    @GetMapping("/cliente/{id}")
    public List<Pedido> getByIdCliente(@PathVariable("id") Long idCliente) throws Exception {
        return pedidoService.findByClienteId(idCliente);
    }

    @GetMapping("/empleado/{id}")
    public List<Pedido> getByEmpleadoId(@PathVariable("id") Long idEmpleado) throws Exception {
        return pedidoService.findByIdEMpleado(idEmpleado);
    }

    @GetMapping("/sucursal/{id}")
    public List<Pedido> getBySucursalId(@PathVariable("id") Long idSucural) throws Exception {
        return pedidoService.findBySucursalId(idSucural);
    }

    @GetMapping("/{pedidoId}/factura")
    public Factura obtenerFacturaPorPedidoId(@PathVariable Long pedidoId) throws Exception {

            Factura factura = pedidoService.obtenerFacturaPorPedidoId(pedidoId);
            return factura;

    }


}
