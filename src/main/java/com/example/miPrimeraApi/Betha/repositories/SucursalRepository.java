package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends BaseRepository<Sucursal, Long> {

    List<Sucursal> findAllByEmpresaId(Long idEmpresa);

}
