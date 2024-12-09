package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    List<Empleado> findAllBySucursalId(Long id);

}
