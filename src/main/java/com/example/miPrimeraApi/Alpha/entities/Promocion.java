package com.example.miPrimeraApi.Alpha.entities;

import com.example.miPrimeraApi.Alpha.entities.enums.TipoPromocion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "promociones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion extends Base {

    private String denominacion;
    @Column(name = "fecha_desde")
    private LocalDate fechaDesde;
    @Column(name = "fecha_hasta")
    private LocalDate fechaHasta;
    @Column(name = "hora_desde")
    private LocalTime horaDesde;
    @Column(name = "hora_hasta")
    private LocalTime horaHasta;
    @Column(name = "descripcion_descuento")
    private String descripcionDescuento;
    @Column(name = "precio_promocional")
    private Double precioPromocional;
    @Column(name = "tipo_promocion")
    private TipoPromocion tipoPromocion;

    @ManyToMany(mappedBy = "promociones")
    @JsonIgnoreProperties("promociones")
    private List<Sucursal> sucursales;

    @OneToMany
    @Builder.Default
    private Set<Imagen> imagenesPromocion = new HashSet<>();

    public void agregarSucursal(Sucursal sucursal) {

        sucursales.add(sucursal);

    }
}
