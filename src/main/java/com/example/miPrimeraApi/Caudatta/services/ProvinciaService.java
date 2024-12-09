package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Provincia;
import com.example.miPrimeraApi.Betha.repositories.PaisRepository;
import com.example.miPrimeraApi.Betha.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvinciaService extends BaseService<Provincia, Long> {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private PaisRepository paisRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository){
        super(provinciaRepository);
    }

@Transactional
    public List<Provincia> getAllByPaisId(Long id) throws Exception {
    try {
        if (!paisRepository.existsById(id)){
            throw new Exception("NO EXISTE ESE ID PAIS EN LA BASE DE DATOS");
        }else if (provinciaRepository.findAllByPaisId(id).isEmpty()){
            throw new Exception("NO SE ENCONTRÓ NINGUNA PROVINCIA VINCULADA A ESE ID PAIS");
        }else {
            return provinciaRepository.findAllByPaisId(id);
        }
    }catch (Exception e){
        throw new Exception(e.getMessage());
    }

    }
}
