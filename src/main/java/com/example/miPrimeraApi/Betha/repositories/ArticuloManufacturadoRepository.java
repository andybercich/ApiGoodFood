package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {
    List<ArticuloManufacturado> getAllByCategoriaId(Long idCategoria);
    List<ArticuloManufacturado> getAllByUnidadMedidaId(Long idUnidadMedida);
}
