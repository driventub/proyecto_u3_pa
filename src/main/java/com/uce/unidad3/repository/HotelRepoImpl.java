package com.uce.unidad3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.unidad3.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

    private static Logger LOG = LogManager.getLogger(HotelRepoImpl.class);

    @PersistenceContext
    private EntityManager e;

    @Override
    public List<Hotel> buscarHotelInnerJoin(String habitacion) {
        // no es necesario poner el ON, dado que ya lo especificamos en la entidad,
        // nomas toca especificar esa relacion anterior
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        List<Hotel> lista =  mQuery.getResultList();
        for (Hotel hotel : lista) {
            hotel.getHabitaciones().size();
        }
        return lista;
    }

    @Override
    public List<Hotel> buscarHotelOuterJoin(String habitacion) {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
    }

    @Override
    public List<Hotel> buscarHotelLeftOuterJoin(String habitacion) {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
    }

    @Override
    public List<Hotel> buscarHotelRightOuterJoin(String habitacion) {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
    }

    

    @Override
    public List<Hotel> buscarHotelInnerJoin() {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha ", Hotel.class);

        return mQuery.getResultList();

    }

    @Override
    public List<Hotel> buscarHotelLeftOuterJoin() {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);

        return mQuery.getResultList();

    }

    // Hace lo mismo que un inner join
    @Override
    public List<Hotel> buscarHotelWhereJoin(String habitacion) {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h, Habitacion ha  WHERE h.id = ha.hotel AND ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public List<Hotel> buscarHotelFetchJoin(String habitacion) {
        LOG.info("Transaccion Activa" + TransactionSynchronizationManager.isActualTransactionActive());
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
    }
}