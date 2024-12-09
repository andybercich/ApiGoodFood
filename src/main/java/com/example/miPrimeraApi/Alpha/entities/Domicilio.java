package com.example.miPrimeraApi.Alpha.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "domicilios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends Base{

    private String calle;
    private Integer numero;
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    @ManyToMany(mappedBy = "domicilios")
    @JsonIgnoreProperties("domocilios")
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente c){
        clientes.add(c);
    }

}
