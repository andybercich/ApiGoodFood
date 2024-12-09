package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Categoria;
import com.example.miPrimeraApi.Alpha.entities.Promocion;
import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Caudatta.services.PromocionService;
import com.example.miPrimeraApi.Caudatta.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promociones")
public class PromocionController extends BaseController<Promocion, Long> {

    @Autowired
    private PromocionService promocionService;

    @Autowired
    private SucursalService sucursalService;


    public PromocionController(PromocionService promocionService) {
        super(promocionService);
    }


    @GetMapping("/sucursal/{id}")
    public List<Promocion> listarPorSucursal(@PathVariable("id") Long id)throws Exception{

        return promocionService.getAllBySucursalId(id);

    }

    @PutMapping("/{idPromocion}/sucursal/{idSucursal}")
    public String asociarManyToMany(@PathVariable("idPromocion") Long idPromocion,
                                    @PathVariable("idSucursal") Long idSucursal) throws Exception {


        Optional<Promocion> promocion = promocionService.buscarPorId(idPromocion);
        Optional<Sucursal> sucursalOpt = sucursalService.buscarPorId(idSucursal);
        if (!promocion.isPresent() && !sucursalOpt.isPresent()){
            throw new Exception("ID DE CATEGORIA Y SUCURSAL NO ENCONTRADOS");
        }else if (!sucursalOpt.isPresent()){
            throw new Exception("ID DE SUCURSAL NO ENCONTRADO");
        }else if (!promocion.isPresent()){
            throw new Exception("ID DE CATEGORIA NO ENCONTRADO");
        }

        Promocion promocion1 = promocion.get();
        Sucursal sucursal = sucursalOpt.get();
        promocion1.agregarSucursal(sucursal);
        sucursal.agregarPromocion(promocion1);

        promocionService.actualizar(promocion1);
        sucursalService.actualizar(sucursal);


        return "ESTA TODO OK";
    }

}
