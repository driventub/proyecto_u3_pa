package com.uce.unidad3.tareas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.tareas.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

    private static Logger LOG = LogManager.getLogger(ClienteRepoImpl.class);

    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente buscar(Integer id) {
        return this.e.find(Cliente.class, id);
    }

    @Override
    public void actualizar(Cliente clie) {
        this.e.merge(clie);

    }

    @Override
    public void eliminar(Integer id) {
        Cliente gBorrar = this.buscar(id);
        this.e.remove(gBorrar);

    }

    @Override
    public void insertar(Cliente clie) {
        this.e.persist(clie);

    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente buscarCedula(String cedula) {
        TypedQuery<Cliente> myTypedQuery = this.e
                .createQuery("SELECT c FROM Cliente c  WHERE c.cedula = :cedula  ", Cliente.class)
                .setParameter("cedula", cedula);
        return myTypedQuery.getSingleResult();
    }

}
