package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Categoria;
import com.example.miPrimeraApi.Alpha.entities.Promocion;
import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Betha.repositories.CategoriaRepository;
import com.example.miPrimeraApi.Betha.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria, Long> {

    public CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Transactional
    public Categoria agregarSubcategoria(Long idCategoriaPadre, Categoria nuevaSubcategoria) throws Exception {
        try{
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);
            if (categoriaPadre != null) {

                nuevaSubcategoria.setCategoriaPadre(categoriaPadre);
                categoriaRepository.save(nuevaSubcategoria);
                return nuevaSubcategoria;
            } else {

                return null;
            }
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorCategoriaPadre(Long idCategoriaPadre) throws Exception {
        try {
            return categoriaRepository.findAllByCategoriaPadre_Id(idCategoriaPadre);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorSucursal(Long idSucursal) throws Exception {
        try {
            if (!sucursalRepository.existsById(idSucursal)){
                throw new Exception("ESTE ID SUCURSAL NO EXISTE");
            }else if(categoriaRepository.findAllBySucursalesId(idSucursal).isEmpty()){
                throw new Exception("ESTE ID SUCURSAL NO ESTA RELACIONADO CON NINGUNA CATEGORIA");
            }
            return categoriaRepository.findAllBySucursalesId(idSucursal);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public void eliminar(Long id) throws Exception {
        try {
            if (!categoriaRepository.existsById(id)) {
                throw new Exception("NO EXISTE UNA CATEGORIA CON ESE ID");
            } else {
                Categoria categoria = categoriaRepository.getReferenceById(id);
                List<Sucursal> sucursales = (List<Sucursal>) categoria.getSucursales();
                for (Sucursal s : sucursales) {
                    s.getCategorias().remove(categoria);
                    sucursalRepository.save(s);
                    break;
                }
                categoriaRepository.delete(categoria);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
