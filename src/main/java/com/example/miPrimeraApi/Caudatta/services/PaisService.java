package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Pais;
import com.example.miPrimeraApi.Betha.repositories.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends BaseService<Pais, Long> {

    public PaisService(PaisRepository paisRepository){
        super(paisRepository);
    }

}
