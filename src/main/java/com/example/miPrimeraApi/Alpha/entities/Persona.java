package com.example.miPrimeraApi.Alpha.entities;

import com.example.miPrimeraApi.Alpha.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona extends Base {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagenPersona;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
