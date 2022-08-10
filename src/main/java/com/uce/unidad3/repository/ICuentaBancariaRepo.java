package com.uce.unidad3.repository;

import com.uce.unidad3.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public void actualizar(CuentaBancaria cuba);

	public CuentaBancaria buscarPorNumero(String numero);
	
}
