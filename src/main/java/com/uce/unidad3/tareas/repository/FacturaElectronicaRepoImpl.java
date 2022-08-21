package com.uce.unidad3.tareas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.tareas.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepoImpl implements IFacturaElectronicaRepo{
	
	private static Logger LOG =  LogManager.getLogger(FacturaElectronicaRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager e;

	@Override
	public void insertar(FacturaElectronica fatr) {
		this.e.persist(fatr);
		
	}

}

