package com.example.miPrimeraApi.Betha.repositories;

import com.example.miPrimeraApi.Alpha.entities.Factura;
import com.example.miPrimeraApi.Alpha.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    List<Pedido> findAllByClienteId(Long idCliente);
    List<Pedido> findAllByEmpleadoId(Long idEmpleado);
    List<Pedido> findAllBySucursalId(Long idSucursal);
    @Query("SELECT p.factura FROM Pedido p WHERE p.id = :pedidoId")
    Factura findFacturaByPedidoId(@Param("pedidoId") Long pedidoId);

}
