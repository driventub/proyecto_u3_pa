package com.uce.unidad3.tareas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IProductoRepo;
import com.uce.unidad3.tareas.repository.modelo.Producto;



@Service
public class ProductoServiceImpl implements IProductoService {
	
	private static Logger LOG =  LogManager.getLogger(ProductoServiceImpl.class);

	@Autowired
	private IProductoRepo prodRepo ;
	
	@Override
	public Producto buscar(Integer id) {
		
		return this.prodRepo.buscar(id);
	}

	
	@Override
	public void actualizar(Producto prod) {
		this.prodRepo.actualizar(prod);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.prodRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Producto prod) {
		this.prodRepo.insertar(prod);
		
	}


	@Override
	public Producto buscarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.prodRepo.buscarCodigoBarras(codigoBarras);
	}

}
