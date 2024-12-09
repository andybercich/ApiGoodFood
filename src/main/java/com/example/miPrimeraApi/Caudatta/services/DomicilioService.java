package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Domicilio;
import com.example.miPrimeraApi.Betha.repositories.ClienteRepository;
import com.example.miPrimeraApi.Betha.repositories.DomicilioRepository;
import com.example.miPrimeraApi.Betha.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.miPrimeraApi.Alpha.entities.Cliente;
import java.util.List;

@Service
public class DomicilioService extends BaseService<Domicilio, Long> {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    @Lazy
    private ClienteService clienteService;


    public DomicilioService(DomicilioRepository domicilioRepository){
        super(domicilioRepository);
    }

    @Transactional
    public List<Domicilio> getAllByLocalidadId(Long idLocalidad) throws Exception {
        try {
            if (!localidadRepository.existsById(idLocalidad)){
                throw new Exception("NO EXISTE UNA LOCALIDAD CON ESE ID");
            }else if (domicilioRepository.findAllByLocalidadId(idLocalidad).isEmpty()){
                throw new Exception("NO EXISTE NINGUN DOMICILIO VINCULADO CON ESE ID LOCALIDAD");
            }else{
                return domicilioRepository.findAllByLocalidadId(idLocalidad);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }

    @Transactional
    public List<Domicilio> getAllByClienteId(Long idCliente) throws Exception {
        try {
            if (!clienteRepository.existsById(idCliente)){
                throw new Exception("NO EXISTE UN CLIENTE CON ESE ID");
            }else if(domicilioRepository.findAllByClientesId(idCliente).isEmpty()){
                throw new Exception("NO HAY NINGÚN DOMICILIO VINCULADO CON ESE ID CLIENTE");
            }else {
                return domicilioRepository.findAllByClientesId(idCliente);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            if (!domicilioRepository.existsById(id)) {
                throw new Exception("NO EXISTE UN DOMICILIO CON ESE ID");
            } else {
                List<Cliente> clientes = clienteRepository.findAll();
                Domicilio domicilio = domicilioRepository.getReferenceById(id);
                for (Cliente c : clientes) {
                    if (c.getDomicilios().contains(domicilio)) {
                        c.getDomicilios().remove(domicilio);
                        clienteRepository.save(c);
                        break;
                    }
                }
                domicilioRepository.delete(domicilio);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
