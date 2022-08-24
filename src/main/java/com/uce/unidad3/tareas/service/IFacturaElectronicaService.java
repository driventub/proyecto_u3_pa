package com.uce.unidad3.tareas.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
    public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items );
}
