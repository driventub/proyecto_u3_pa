package com.uce.unidad3.tareas.repository.modelo;

import java.math.BigDecimal;

public class Datos {
    private String numeroFactura;
    private BigDecimal monto;
    private Integer items;
    public String getNumeroFactura() {
        return numeroFactura;
    }
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public Integer getItems() {
        return items;
    }
    public void setItems(Integer items) {
        this.items = items;
    }

    
}
