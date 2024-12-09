package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Cliente;
import com.example.miPrimeraApi.Alpha.entities.Domicilio;
import com.example.miPrimeraApi.Betha.repositories.ClienteRepository;
import com.example.miPrimeraApi.Betha.repositories.DomicilioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente, Long> {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    @Lazy
    private DomicilioService domicilioService;

    public ClienteService(ClienteRepository clienteRepository){
        super(clienteRepository);
    }


    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            if (!clienteRepository.existsById(id)) {
                throw new Exception("NO EXISTE UN CLIENTE CON ESE ID");
            } else {
                Cliente cliente = clienteRepository.getReferenceById(id);
                List<Domicilio> domicilios = cliente.getDomicilios();
                for (Domicilio domicilio : domicilios) {
                    domicilio.getClientes().remove(cliente);
                    domicilioRepository.save(domicilio);
                }
                clienteRepository.delete(cliente);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
