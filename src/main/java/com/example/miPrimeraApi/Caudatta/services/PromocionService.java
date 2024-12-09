package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Promocion;
import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Betha.repositories.PromocionRepository;
import com.example.miPrimeraApi.Betha.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromocionService extends BaseService<Promocion, Long> {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private PromocionRepository promocionRepository;

    public PromocionService(PromocionRepository promocionRepository){
        super(promocionRepository);
    }


    public List<Promocion> getAllBySucursalId(Long idSucursal) throws Exception {
        try {
            if (!sucursalRepository.existsById(idSucursal)){
                throw new Exception("NO EXISTE UNA SUCURSAL CON ESE ID");
            }else if(promocionRepository.findAllBySucursalesId(idSucursal).isEmpty()){
                throw new Exception("NO HAY NINGUNA PROMOCION VINCULADO CON ESE ID SUCURSAL");
            }else {
                return promocionRepository.findAllBySucursalesId(idSucursal);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            if (!promocionRepository.existsById(id)) {
                throw new Exception("NO EXISTE UNA PROMOCION CON ESE ID");
            } else {
                Promocion promocion = promocionRepository.getReferenceById(id);
                List<Sucursal> sucursales = promocion.getSucursales();
                for (Sucursal s : sucursales) {
                    s.getPromociones().remove(promocion);
                    sucursalRepository.save(s);
                }
                promocionRepository.delete(promocion);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
