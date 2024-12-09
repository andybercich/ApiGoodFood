package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.ArticuloManufacturado;
import com.example.miPrimeraApi.Betha.repositories.ArticuloManufacturadoRepository;
import com.example.miPrimeraApi.Betha.repositories.CategoriaRepository;
import com.example.miPrimeraApi.Betha.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoService(ArticuloManufacturadoRepository articuloManufacturadoRepository){
        super(articuloManufacturadoRepository);
    }

    @Transactional
    public List<ArticuloManufacturado> getAllByCategoriaId(Long idCategoria) throws Exception {

        try {
            if (!categoriaRepository.existsById(idCategoria)){
                throw new Exception("ESTE ID CATEGORIA NO EXISTE");
            }
            else if (articuloManufacturadoRepository.getAllByCategoriaId(idCategoria).isEmpty()){
                throw new Exception("ESTE ID CATEGORIA NO ESTA RELACIONADO CON NINGUN ARTICULO MANUFACTURADO");
            }else {
                return articuloManufacturadoRepository.getAllByCategoriaId(idCategoria);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }
    @Transactional
    public List<ArticuloManufacturado> getAllByUnidadMedidaId(Long idUnidadMedida) throws Exception {

        try {
            if (!unidadMedidaRepository.existsById(idUnidadMedida)){
                throw new Exception("ESTE ID UNIDAD MEDIDA NO EXISTE");
            }
            else if (articuloManufacturadoRepository.getAllByUnidadMedidaId(idUnidadMedida).isEmpty()){
                throw new Exception("ESTE ID UNIDAD MEDIDAD NO ESTA RELACIONADO CON NINGUN ARTICULO MANUFACTURADO");
            }else {
                return articuloManufacturadoRepository.getAllByUnidadMedidaId(idUnidadMedida);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



    }
}
