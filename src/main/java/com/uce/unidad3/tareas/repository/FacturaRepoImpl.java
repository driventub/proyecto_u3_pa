package com.uce.unidad3.tareas.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.unidad3.tareas.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	private static Logger logger = LogManager.getLogger(FacturaRepoImpl.class);

	@PersistenceContext
	private EntityManager e;

	@Override
	public Factura buscar(Integer id) {
		return this.e.find(Factura.class, id);
	}

	@Override
	public List<Factura> buscarTodos() {
		TypedQuery<Factura> myTypedQuery = (TypedQuery<Factura>) this.e
				.createQuery("SELECT f FROM Factura f    ", Factura.class);
		return myTypedQuery.getResultList();

	}

	@Override
	public void actualizar(Factura fact) {
		this.e.merge(fact);

	}

	@Override
	public void eliminar(Integer id) {
		Factura gBorrar = this.buscar(id);
		this.e.remove(gBorrar);

	}

	@Override
	public void insertar(Factura fact) {
		this.e.persist(fact);

	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(LocalDateTime fecha) {

		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <= :fecha", Factura.class)
				.setParameter("fecha", fecha);
		return mQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoin(LocalDateTime fecha) {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <= :fecha", Factura.class)
				.setParameter("fecha", fecha);
		return mQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaLeftOuterJoin(LocalDateTime fecha) {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE f.fecha <= :fecha", Factura.class)
				.setParameter("fecha", fecha);
		return mQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaRightOuterJoin(LocalDateTime fecha) {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE f.fecha <= :fecha",
						Factura.class)
				.setParameter("fecha", fecha);
		return mQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(LocalDateTime fecha) {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE f.fecha <= :fecha", Factura.class)
				.setParameter("fecha", fecha);
		return mQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d ", Factura.class);

		return mQuery.getResultList();

	}

	@Override
	public List<Factura> buscarFacturaLeftOuterJoin() {
		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d", Factura.class);

		return mQuery.getResultList();

	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(LocalDateTime fecha) {

		TypedQuery<Factura> mQuery = this.e
				.createQuery("SELECT f FROM Factura f , Detalle d WHERE f.id = d.factura AND f.fecha <= :fecha",
						Factura.class)
				.setParameter("fecha", fecha);

		return mQuery.getResultList();
	}
}