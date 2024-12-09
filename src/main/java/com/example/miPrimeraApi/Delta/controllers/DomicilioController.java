package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Categoria;
import com.example.miPrimeraApi.Alpha.entities.Cliente;
import com.example.miPrimeraApi.Alpha.entities.Domicilio;
import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Caudatta.services.ClienteService;
import com.example.miPrimeraApi.Caudatta.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController extends BaseController<Domicilio, Long> {

    @Autowired
    private DomicilioService domicilioService;

    @Autowired
    private ClienteService clienteService;

    public DomicilioController(DomicilioService domicilioService){
        super(domicilioService);
    }



    @GetMapping("/localidad/{idLocalidad}")
    public List<Domicilio> getAllByLocalidadId(@PathVariable("idLocalidad") Long idLocalidad) throws Exception {
        return domicilioService.getAllByLocalidadId(idLocalidad);
    }


    @GetMapping("/cliente/{idCliente}")
    public List<Domicilio> getAllByClienteId(@PathVariable("idCliente") Long idCliente) throws Exception {
        return domicilioService.getAllByClienteId(idCliente);
    }


    @PutMapping("/{idDomicilio}/cliente/{idCliente}")
    public String asociarManyToMany (@PathVariable("idDomicilio") Long idDomicilio,
                                     @PathVariable("idCliente") Long idCliente) throws Exception {


        Optional<Domicilio> domicilio = domicilioService.buscarPorId(idDomicilio);
        Optional<Cliente> cliente = clienteService.buscarPorId(idCliente);
        if (!domicilio.isPresent() && !cliente.isPresent()){
            throw new Exception("ID DE DOMICILIO Y CLIENTE NO ENCONTRADOS");
        }else if (!cliente.isPresent()){
            throw new Exception("ID DE CLIENTE NO ENCONTRADO");
        }else if (!domicilio.isPresent()){
            throw new Exception("ID DE DOMICILIO NO ENCONTRADO");
        }

        Domicilio domicilio1 = domicilio.get();
        Cliente cliente1 = cliente.get();



        domicilio1.agregarCliente(cliente1);
        cliente1.agregarDomicilio(domicilio1);

        clienteService.actualizar(cliente1);
        domicilioService.actualizar(domicilio1);


        return "ESTA TODO OK";

    }

}
