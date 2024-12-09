package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Empleado;
import com.example.miPrimeraApi.Betha.repositories.EmpleadoRepository;
import com.example.miPrimeraApi.Betha.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoService extends BaseService<Empleado, Long>{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository){
        super(empleadoRepository);
    }


    @Transactional
    public List<Empleado> getAllBySucursalId(Long idSucursal) throws Exception {
        try {
            if (!sucursalRepository.existsById(idSucursal)){

                throw new Exception("NO EXISTE NINGUNA SUCURSAL CON ESE ID");

            }else if (empleadoRepository.findAllBySucursalId(idSucursal).isEmpty()){
                throw new Exception("ESTE ID SUCURSAL NO ESTÁ VINCULADO CON NINGÚN EMPLEADO");
            }
            return empleadoRepository.findAllBySucursalId(idSucursal);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }
}
