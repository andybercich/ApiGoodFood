package com.example.miPrimeraApi.Alpha.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria extends Base{

    private String denominacion;

    @OneToMany(mappedBy = "categoriaPadre")
    @JsonIgnoreProperties("categoriaPadre")
    private Set<Categoria> subcategorias ;

    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    @JsonIgnoreProperties("subcategorias")
    private Categoria categoriaPadre;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnoreProperties("categorias")
    private Set<Sucursal> sucursales;

    public void agregarSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    public Categoria getCategoriaPadre() {
        return categoriaPadre;
    }

    public Set<Categoria> getSubcategorias() {
        return subcategorias;
    }
    public void AgregarSubCategoria (Categoria categoria){
        subcategorias.add(categoria);
    }
}
