package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturadoDetalle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle, Long> {

    List<ArticuloManufacturadoDetalle> findAllByArticuloInsumoId(Long idArticuloInsumo);
    List<ArticuloManufacturadoDetalle> findAllByArticuloManufacturadoId(Long idArticuloManufacturado);
}
