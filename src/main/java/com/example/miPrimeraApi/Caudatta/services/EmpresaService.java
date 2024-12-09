package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Empresa;
import com.example.miPrimeraApi.Betha.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends BaseService<Empresa, Long> {

    public EmpresaService(EmpresaRepository empresaRepository){
        super(empresaRepository);
    }

}
