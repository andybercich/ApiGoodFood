package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Cliente;
import com.example.miPrimeraApi.Caudatta.services.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController<Cliente, Long>{

    public ClienteController(ClienteService clienteService){
        super(clienteService);
    }

}
