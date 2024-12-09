package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturadoDetalle;
import com.example.miPrimeraApi.Betha.repositories.ArticuloInsumoRepository;
import com.example.miPrimeraApi.Betha.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.miPrimeraApi.Betha.repositories.ArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoDetalleService extends BaseService<ArticuloManufacturadoDetalle, Long> {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository){
        super(articuloManufacturadoDetalleRepository);
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> getAllByArticuloInsumoId(Long idInsumo) throws Exception {

        try {
            if (!articuloInsumoRepository.existsById(idInsumo)){
                throw new Exception("ESTE ID INSUMO NO EXISTE");
            } else if (articuloManufacturadoDetalleRepository.findAllByArticuloInsumoId(idInsumo).isEmpty()) {
                throw new Exception("ESTE ID INSUMO NO ESTÁ RELACIONADO CON NINGÚN DETALLE ARTICULO");
            } else {
                return articuloManufacturadoDetalleRepository.findAllByArticuloInsumoId(idInsumo);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> getAllByArticuloManufacturadoId(Long idManufacturado) throws Exception {
        try {
            if (!articuloManufacturadoRepository.existsById(idManufacturado)){

                throw new Exception("ESTE ID MANUFACTURADO NO EXISTE");

            }
            else if (articuloManufacturadoDetalleRepository.findAllByArticuloManufacturadoId(idManufacturado).isEmpty()){
                throw new Exception("ESTE ID MANUFACTURADO NO ESTA RELACIONADO CON NINGUN DETALLE FACTURA");
            }else {
                return articuloManufacturadoDetalleRepository.findAllByArticuloManufacturadoId(idManufacturado) ;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

}
