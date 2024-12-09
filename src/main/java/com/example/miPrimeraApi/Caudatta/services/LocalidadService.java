package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Localidad;
import com.example.miPrimeraApi.Betha.repositories.LocalidadRepository;
import com.example.miPrimeraApi.Betha.repositories.ProvinciaRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalidadService extends BaseService<Localidad, Long> {

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public LocalidadService(LocalidadRepository localidadRepository){
        super(localidadRepository);
    }


    @Transactional
    public List<Localidad> getAllByProvinciaId(Long idProvincia) throws Exception {
        try {
            if (!provinciaRepository.existsById(idProvincia)){

                throw new Exception("NO EXISTE UNA PROVINCIA CON ESE ID");

            }else if (localidadRepository.findAllByProvinciaId(idProvincia).isEmpty()){
                throw new Exception("NO HAY NINGUNA LOCALIDAD VINCULADA CON ESE ID PROVINCIA");
            }else{
                return localidadRepository.findAllByProvinciaId(idProvincia);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

}
