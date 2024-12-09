package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.*;
import com.example.miPrimeraApi.Betha.repositories.CategoriaRepository;
import com.example.miPrimeraApi.Betha.repositories.EmpresaRepository;
import com.example.miPrimeraApi.Betha.repositories.PromocionRepository;
import com.example.miPrimeraApi.Betha.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService extends BaseService<Sucursal, Long> {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public SucursalService(SucursalRepository sucursalRepository){
        super(sucursalRepository);
    }

    @Transactional
    public List<Sucursal> findAllByEmpresaId(Long idEmpresa) throws Exception {
        try {
            if (!empresaRepository.existsById(idEmpresa)){
                throw new Exception("ESTE ID EMPRESA NO EXISTE");
            }
            if (sucursalRepository.findAllByEmpresaId(idEmpresa).isEmpty()){
               throw new Exception("ESTE ID EMPRESA NO ESTA RELACIONADO CON NINGUNA SUCURSAL");
            }else{
                return sucursalRepository.findAllByEmpresaId(idEmpresa);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }


    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            if (!sucursalRepository.existsById(id)) {
                throw new Exception("NO EXISTE UNA SUCURSAL CON ESE ID");
            } else {
                List<Promocion> promociones = promocionRepository.findAll();
                Sucursal sucursal = sucursalRepository.getReferenceById(id);
                for (Promocion p : promociones) {
                    if (p.getSucursales().contains(sucursal)) {
                        p.getSucursales().remove(sucursal);
                        promocionRepository.save(p);
                        break;
                    }
                }
                List<Categoria> categorias = categoriaRepository.findAll();
                for (Categoria c : categorias){
                    if (c.getSucursales().contains(sucursal)){
                        c.getSucursales().remove(sucursal);
                        categoriaRepository.save(c);
                        break;

                    }
                }
                sucursalRepository.delete(sucursal);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


}
