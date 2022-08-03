package com.uce.unidad3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

    private static Logger logger = LogManager.getLogger(HotelRepoImpl.class);

    @PersistenceContext
    private EntityManager e;

    @Override
    public List<Hotel> buscarHotelInnerJoin(String habitacion) {
        // no es necesario poner el ON, dado que ya lo especificamos en la entidad,
        // nomas toca especificar esa relacion anterior
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
                .setParameter("habi", habitacion);
        return mQuery.getResultList();
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
    public List<Hotel> buscarHotelFetchJoin(String habitacion) {
        TypedQuery<Hotel> mQuery = this.e
                .createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :habi", Hotel.class)
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
}