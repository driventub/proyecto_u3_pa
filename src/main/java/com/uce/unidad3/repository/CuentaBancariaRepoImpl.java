package com.uce.unidad3.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.unidad3.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	private static Logger LOG = LogManager.getLogger(CuentaBancariaRepoImpl.class);

	@PersistenceContext
	private EntityManager e;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuba) {
		LOG.info("Transaccion Activa" + TransactionSynchronizationManager.isActualTransactionActive());
		this.e.merge(cuba);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		LOG.info("Transaccion Activa" + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.e.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numero", CuentaBancaria.class)
				.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

}
