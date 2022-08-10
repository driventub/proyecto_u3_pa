package com.uce.unidad3.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.repository.ICuentaBancariaRepo;
import com.uce.unidad3.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	private static Logger LOG = LogManager.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepo cubaRepo;

	@Override
	public void actualizar(CuentaBancaria cuba) {
		this.cubaRepo.actualizar(cuba);

	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cubaRepo.buscarPorNumero(numero);
	}

}
