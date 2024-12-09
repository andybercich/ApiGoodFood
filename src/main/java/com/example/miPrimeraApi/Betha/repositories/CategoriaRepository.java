package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long> {

    List<Categoria> findAllByCategoriaPadre_Id(Long idCategoriaPadre);

    List<Categoria> findAllBySucursalesId(Long idSucursal);

}
