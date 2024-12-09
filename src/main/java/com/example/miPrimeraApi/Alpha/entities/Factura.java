package com.example.miPrimeraApi.Alpha.entities;


import com.example.miPrimeraApi.Alpha.entities.enums.FormaPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends Base{

    @Column(name = "Fecha_Facturacion")
    private LocalDate fechaFacturacion;

    private Integer mpPaymentId;

    private Integer mpMerchantOrderId;

    private String mpPreferenceId;

    private String mpPaymentType;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    private double totalVenta;

}
