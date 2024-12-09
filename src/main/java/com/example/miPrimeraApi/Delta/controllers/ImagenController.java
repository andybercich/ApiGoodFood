package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Imagen;
import com.example.miPrimeraApi.Caudatta.services.ImagenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen, Long> {

    public ImagenController(ImagenService imagenService){
        super(imagenService);
    }

}
