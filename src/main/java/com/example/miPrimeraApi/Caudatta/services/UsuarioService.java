package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Usuario;
import com.example.miPrimeraApi.Betha.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Long> {

    public UsuarioService(UsuarioRepository usuarioRepository){
        super(usuarioRepository);
    }

}
