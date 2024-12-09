package com.example.miPrimeraApi.Caudatta.services;

import com.example.miPrimeraApi.Alpha.entities.Factura;
import com.example.miPrimeraApi.Betha.repositories.BaseRepository;
import com.example.miPrimeraApi.Betha.repositories.FacturaRepository;
import com.example.miPrimeraApi.Betha.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService extends BaseService<Factura,Long> {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        super(facturaRepository);
    }

}
