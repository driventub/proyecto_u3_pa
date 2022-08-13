package com.uce.unidad3.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

    private static Logger LOG = LogManager.getLogger(TransferenciaRepoImpl.class);

    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Transferencia tran) {
        this.e.persist(tran);

    }

    @Override
    public Transferencia buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.e.find(Transferencia.class, id);
    }

}
