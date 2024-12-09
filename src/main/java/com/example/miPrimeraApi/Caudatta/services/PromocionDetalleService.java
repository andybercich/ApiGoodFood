package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.PromocionDetalle;
import com.example.miPrimeraApi.Betha.repositories.PromocionDetalleRepository;
import com.example.miPrimeraApi.Betha.repositories.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromocionDetalleService extends BaseService<PromocionDetalle, Long> {
    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private PromocionDetalleRepository promocionDetalleRepository;


    public PromocionDetalleService(PromocionDetalleRepository promocionDetalleRepository){
        super(promocionDetalleRepository);
    }

    @Transactional
    public List<PromocionDetalle> getAllByIdPromocion (Long idPromocion) throws Exception {
        try {
            if (!promocionDetalleRepository.existsById(idPromocion)){
                throw new Exception("ESTE ID PROMOCION NO EXISTE");
            }
            if (promocionDetalleRepository.findAllByPromocionId(idPromocion).isEmpty()){
                throw new Exception("NO SE ENCONTRÓ NINGUNA PROMOCION DETALLE VINCULADO CON ESTE ID PROMOCION");
            }else {
                return promocionDetalleRepository.findAllByPromocionId(idPromocion);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public List<PromocionDetalle> getAllByIdArticulo (Long idArticulo) throws Exception {
        try {
            if (promocionDetalleRepository.findAllByArticuloId(idArticulo).isEmpty()){
                throw new Exception("NO SE ENCONTRÓ NINGUNA PROMOCION DETALLE VINCULADO CON ESTE ID ARTICULO");
            }else {
                return promocionDetalleRepository.findAllByArticuloId(idArticulo);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
