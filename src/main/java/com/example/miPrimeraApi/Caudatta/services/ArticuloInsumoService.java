package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.ArticuloInsumo;
import com.example.miPrimeraApi.Betha.repositories.ArticuloInsumoRepository;
import com.example.miPrimeraApi.Betha.repositories.CategoriaRepository;
import com.example.miPrimeraApi.Betha.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoService(ArticuloInsumoRepository articuloInsumoRepository){
        super(articuloInsumoRepository);
    }

    @Transactional
    public List<ArticuloInsumo> getAllByCategoriaId(Long idCategoria) throws Exception {
        try {
            if (!categoriaRepository.existsById(idCategoria)){
                throw new Exception("ESTE ID CATEGORIA NO EXISTE");
            }
            else if (articuloInsumoRepository.getAllByCategoriaId(idCategoria).isEmpty()){
                throw new Exception("ESTE ID CATEGORIA NO ESTA RELACIONADO CON NINGUN ARTICULO INSUMO");
            }else {
                return articuloInsumoRepository.getAllByCategoriaId(idCategoria);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }
    @Transactional
    public List<ArticuloInsumo> getAllByUnidadMedidaId(Long idUnidadMedida) throws Exception {

        try {
            if (!unidadMedidaRepository.existsById(idUnidadMedida)){
                throw new Exception("ESTE ID UNIDAD MEDIDA NO EXISTE");
            }
            else if (articuloInsumoRepository.getAllByUnidadMedidaId(idUnidadMedida).isEmpty()){
                throw new Exception("ESTE ID UNIDAD MEDIDAD NO ESTA RELACIONADO CON NINGUN ARTICULO INSUMO");
            }else {
                return articuloInsumoRepository.getAllByUnidadMedidaId(idUnidadMedida);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }




    }

}
