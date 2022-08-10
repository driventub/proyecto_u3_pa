package com.uce.unidad3.service;

import com.uce.unidad3.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
   
    public void actualizar(CuentaBancaria cuba);

    public CuentaBancaria buscarPorNumero(String numero);

}
