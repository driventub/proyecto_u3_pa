package com.uce.unidad3.tareas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IFacturaRepo;
import com.uce.unidad3.tareas.repository.modelo.Factura;



@Service
public class FacturaServiceImpl implements IFacturaService {
	
	private static Logger logger =  LogManager.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepo factRepo ;
	
	@Override
	public Factura buscar(Integer id) {
		
		return this.factRepo.buscar(id);
	}

	

	@Override
	public void actualizar(Factura fact) {
		this.factRepo.actualizar(fact);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.factRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Factura fact) {
		this.factRepo.insertar(fact);
		
	}



	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.factRepo.buscarNumero(numero);
	}

}