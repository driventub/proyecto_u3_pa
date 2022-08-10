package com.uce.unidad3.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
	
	@Id
    @Column(name = "cuba_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuba_id_seq")
    @SequenceGenerator(name = "cuba_id_seq", sequenceName = "cuba_id_seq", allocationSize = 1)
	private Integer id;

    @Column(name = "cuba_numero")
    private String numero;

    @Column(name = "cuba_saldo")
    private BigDecimal saldo;

    @Column(name = "cuba_tipo")
    private String tipo;

    @OneToMany(mappedBy = "ctaOrigen")
    private List<Transferencia> transOrigen;
    
    @OneToMany(mappedBy = "ctaDestino")
    private List<Transferencia> transDestino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public List<Transferencia> getTransOrigen() {
        return transOrigen;
    }

    public void setTransOrigen(List<Transferencia> transOrigen) {
        this.transOrigen = transOrigen;
    }

    public List<Transferencia> getTransDestino() {
        return transDestino;
    }

    public void setTransDestino(List<Transferencia> transDestino) {
        this.transDestino = transDestino;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
                + ", transDestino=" + transDestino + ", transOrigen=" + transOrigen + "]";
    }

    

    
    
}