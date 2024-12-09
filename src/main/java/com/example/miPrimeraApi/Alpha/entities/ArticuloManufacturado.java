package com.example.miPrimeraApi.Alpha.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "artiulos_manufacturados")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloManufacturado extends Articulo{

    private String descripcion;
    @Column(name = "tiempo_estimado_minutos")
    private Integer tiempoEstimadoMinutos;
    private String preparacion;

}
