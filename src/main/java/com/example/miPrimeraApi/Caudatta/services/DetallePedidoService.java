package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.DetallePedido;
import com.example.miPrimeraApi.Betha.repositories.ArticuloInsumoRepository;
import com.example.miPrimeraApi.Betha.repositories.DetallePedidoRepository;
import com.example.miPrimeraApi.Betha.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallePedidoService extends BaseService<DetallePedido, Long> {
    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository){
        super(detallePedidoRepository);
    }

    @Transactional
    public List<DetallePedido> listarByPedido(Long idPedido) throws Exception {
        try {
            if (pedidoRepository.existsById(idPedido)){
                throw new Exception("ESTE ID PEDIDO NO EXISTE");
            } else if (detallePedidoRepository.findAllByPedidoId(idPedido).isEmpty()) {
                throw new Exception("ESTE ID PEDIDO NO ESTÁ RELACIONADO CON NINGÚN PEDIDO");
            }
            return detallePedidoRepository.findAllByPedidoId(idPedido);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }

    @Transactional
    public List<DetallePedido> listarByArticulo(Long idArticulo) throws Exception {
        try {
            if(detallePedidoRepository.findAllByArticuloId(idArticulo).isEmpty()){
                throw new Exception("ESTE ID ARTICULO NO ESTÁ RELACIONADO CON NINGUN DETALLE PEDIDO");
            }else{
                return detallePedidoRepository.findAllByArticuloId(idArticulo);

            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }


}
