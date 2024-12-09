package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Imagen;
import com.example.miPrimeraApi.Betha.repositories.ImagenRepository;
import org.springframework.stereotype.Service;

@Service
public class ImagenService extends BaseService<Imagen, Long>{

    public ImagenService(ImagenRepository imagenRepository){
        super(imagenRepository);
    }

}
