package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.DetallePedido;
import com.example.miPrimeraApi.Alpha.entities.Factura;
import com.example.miPrimeraApi.Alpha.entities.Pedido;
import com.example.miPrimeraApi.Betha.repositories.ClienteRepository;
import com.example.miPrimeraApi.Betha.repositories.EmpleadoRepository;
import com.example.miPrimeraApi.Betha.repositories.PedidoRepository;
import com.example.miPrimeraApi.Betha.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PedidoService extends BaseService<Pedido, Long>{
    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoService detallePedidoService;

    public PedidoService(PedidoRepository pedidoRepository){
        super(pedidoRepository);
    }

    @Transactional
    public Pedido calcularTotal(Pedido pedido) throws Exception {
        try{

            List<DetallePedido> detallePedidos = detallePedidoService.listarByPedido(pedido.getId());
            Double total = 0.0;

            if (detallePedidos != null && !detallePedidos.isEmpty()) {
                total = detallePedidos.stream()
                        .mapToDouble(detalle -> detalle.getSubTotal())
                        .sum();
            }

            pedido.setTotal(total);
            return pedidoRepository.save(pedido);

        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido actualizar(Pedido pedido) throws Exception {
        try{
            calcularTotal(pedido);
            return pedidoRepository.save(pedido);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Pedido> findByIdEMpleado(Long idEmpleado) throws Exception {
        try {
            if (!empleadoRepository.existsById(idEmpleado)){
                throw new Exception("ESTE ID EMPLEADO NO EXISTE");
            }
            if (pedidoRepository.findAllByEmpleadoId(idEmpleado).isEmpty()){
                throw new Exception("ESTE ID EMPLEADO NO ESTÁ RELACIONADO CON NINGÚN PEDIDO");
            }else{
                return pedidoRepository.findAllByEmpleadoId(idEmpleado);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Transactional
    public List<Pedido> findByClienteId(Long idCliente) throws Exception {
        try {
            if (!clienteRepository.existsById(idCliente)){
                throw new Exception("ESTE ID CLIENTE NO EXISTE");
            }
            if (pedidoRepository.findAllByClienteId(idCliente).isEmpty()){
                throw new Exception("ESTE ID CLIENE NO ESTÁ RELACIONCADO CON NINGÚN PEDIDO");
            }else{
                return pedidoRepository.findAllByClienteId(idCliente);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }
    @Transactional
    public List<Pedido> findBySucursalId(Long idSucursal) throws Exception {
        try {
            if (!sucursalRepository.existsById(idSucursal)){
                throw new Exception("ESTE ID SUCURSAL NO EXISTE");
            }
            if (pedidoRepository.findAllBySucursalId(idSucursal).isEmpty()){
                throw new Exception("ESTE ID SUCURSAL NO ESTÁ RELACIONADO CON NINGÚN PEDIDO");
            }else{
                return pedidoRepository.findAllBySucursalId(idSucursal);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Transactional
    public Factura obtenerFacturaPorPedidoId(Long pedidoId) throws Exception {
        try {
            if (!pedidoRepository.existsById(pedidoId)){
                throw new Exception("ESTE PEDIDO ID NO EXISTE");
            }
            Factura factura = pedidoRepository.findFacturaByPedidoId(pedidoId);
            if (factura == null) {
                throw new Exception("No se encontró la factura para el ID del pedido proporcionado.");
            }
            return factura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
