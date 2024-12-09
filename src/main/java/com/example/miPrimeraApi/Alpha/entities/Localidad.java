package com.example.miPrimeraApi.Alpha.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "localidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localidad extends Base{

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

}
