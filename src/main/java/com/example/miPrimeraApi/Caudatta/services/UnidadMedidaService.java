package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.UnidadMedida;
import com.example.miPrimeraApi.Betha.repositories.UnidadMedidaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService extends BaseService<UnidadMedida, Long> {

    public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository){
        super(unidadMedidaRepository);
    }

}
