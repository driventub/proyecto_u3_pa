package com.uce.unidad3.tareas.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "factura_electronica")
public class FacturaElectronica {
    
    @Id
    @Column(name = "fatr_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fatr_id_seq")
    @SequenceGenerator(name = "fatr_id_seq", sequenceName = "fatr_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "fatr_numero")
    private String numero;

    @Column(name = "fatr_fecha")
    private LocalDateTime fechaCreacion;

    @Column(name = "fatr_monto")
    private BigDecimal monto;

    @Column(name = "fatr_num_items")
    private Integer numItems;



    // Get y Set
  
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public Integer getNumItems() {
        return numItems;
    }
    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    
}
