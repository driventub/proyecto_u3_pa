package com.uce.unidad3.tareas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.tareas.repository.modelo.Detalle;

@Repository
@Transactional
public class DetalleRepoImpl implements IDetalleRepo{
	
	private static Logger logger =  LogManager.getLogger(DetalleRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	public Detalle buscar(Integer id) {
		return this.e.find(Detalle.class, id);
	}

	
	@Override
	public void actualizar(Detalle deta) {
		this.e.merge(deta);
		
	}

	@Override
	public void eliminar(Integer id) {
		Detalle gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	public void insertar(Detalle deta) {
		this.e.persist(deta);
		
	}

}
