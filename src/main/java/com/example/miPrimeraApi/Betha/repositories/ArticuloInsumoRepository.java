package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.ArticuloInsumo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    List<ArticuloInsumo> getAllByCategoriaId(Long idCategoria);
    List<ArticuloInsumo> getAllByUnidadMedidaId(Long idUnidadMedida);
}
