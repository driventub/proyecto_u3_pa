package com.uce.unidad3.tareas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.tareas.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{
	
	private static Logger LOG =  LogManager.getLogger(ProductoRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager e;
	
	@Override

	public Producto buscar(Integer id) {
		return this.e.find(Producto.class, id);
	}

	
	@Override
	public void actualizar(Producto prod) {
		this.e.merge(prod);
		
	}

	@Override
	public void eliminar(Integer id) {
		Producto gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Producto prod) {
		this.e.persist(prod);
		
	}


	@Override
	public Producto buscarCodigoBarras(String codigoBarras) {
		TypedQuery<Producto> myTypedQuery = this.e
				.createQuery("SELECT p FROM Producto p  WHERE p.codigoBarras = :numero  ", Producto.class)
				.setParameter("numero", codigoBarras);
		return myTypedQuery.getSingleResult();
		
	}

}
