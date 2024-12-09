package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.DetallePedido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {

    List<DetallePedido> findAllByPedidoId(Long idPedido);

    List<DetallePedido> findAllByArticuloId(Long idArticulo);

}
