package com.example.miPrimeraApi.Delta.controllers;

import com.example.miPrimeraApi.Alpha.entities.Categoria;
import com.example.miPrimeraApi.Alpha.entities.Sucursal;
import com.example.miPrimeraApi.Caudatta.services.CategoriaService;
import com.example.miPrimeraApi.Caudatta.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<Categoria, Long> {

    public CategoriaController(CategoriaService categoriaService){
        super(categoriaService);
    }

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/subcategoria/{id_CP}")
    public Optional<Categoria> agregarSubcategoria(@PathVariable Long id_CP, @RequestBody Categoria subcategoria) throws Exception {
        Categoria catPadre = categoriaService.agregarSubcategoria(id_CP, subcategoria);
        return Optional.ofNullable(catPadre);
    }

    @GetMapping("/categoriaPadre/{id}")
    public ResponseEntity<List<Categoria>> listarPorCategoriaPadre(@PathVariable Long id) throws Exception {
        List<Categoria> categorias = categoriaService.listarPorCategoriaPadre(id);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/sucursal/{id}")
    public List<Categoria> listarPorSucursal(@PathVariable("id") Long id)throws Exception{

        return categoriaService.listarPorSucursal(id);

    }

    @PutMapping("/{idCategoria}/sucursal/{idSucursal}")
    public String asociarManyToMany(@PathVariable("idCategoria") Long idCategoria,
                                                    @PathVariable("idSucursal") Long idSucursal) throws Exception {


        Optional<Categoria> categoria = categoriaService.buscarPorId(idCategoria);
        Optional<Sucursal> sucursalOpt = sucursalService.buscarPorId(idSucursal);
        if (!categoria.isPresent() && !sucursalOpt.isPresent()){
            throw new Exception("ID DE CATEGORIA Y SUCURSAL NO ENCONTRADOS");
        }else if (!sucursalOpt.isPresent()){
            throw new Exception("ID DE SUCURSAL NO ENCONTRADO");
        }else if (!categoria.isPresent()){
            throw new Exception("ID DE CATEGORIA NO ENCONTRADO");
        }

        Categoria categoria1 = categoria.get();
        Sucursal sucursal = sucursalOpt.get();
        categoria1.agregarSucursal(sucursal);
        sucursal.agregarCategoria(categoria1);

        categoriaService.actualizar(categoria1);
        sucursalService.actualizar(sucursal);


        return "ESTA TODO OK";
    }


}
