package com.uce.unidad3.tareas.hilos;

import java.math.BigDecimal;

public class DatosParalelo {
    private String numeroFactura;
    private BigDecimal monto;
    private Integer items;

    
    public DatosParalelo(String numeroFactura, BigDecimal monto, Integer items) {
        super();
        this.numeroFactura = numeroFactura;
        this.monto = monto;
        this.items = items;
    }
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
    @Override
    public String toString() {
        return "Datos [items=" + items + ", monto=" + monto + ", numeroFactura=" + numeroFactura + "]";
    }

    

}
