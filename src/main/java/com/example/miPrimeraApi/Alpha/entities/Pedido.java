package com.example.miPrimeraApi.Alpha.entities;

import com.example.miPrimeraApi.Alpha.entities.enums.Estado;
import com.example.miPrimeraApi.Alpha.entities.enums.FormaPago;
import com.example.miPrimeraApi.Alpha.entities.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends Base{

    @Column(name = "hora_estimada_finalizacion")
    private LocalTime horaEstimadaFinalizacion;

    @Column(name = "total")
    private Double total = 0.0;

    @Column(name = "total_costo")
    private Double totalCosto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_envio")
    private TipoEnvio tipoEnvio;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @OneToOne
    private Factura factura;

}
