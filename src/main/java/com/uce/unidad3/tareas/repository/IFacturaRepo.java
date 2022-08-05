package com.uce.unidad3.tareas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.unidad3.tareas.repository.modelo.Factura;

public interface IFacturaRepo {
	public Factura buscar(Integer id);

	public List<Factura> buscarTodos();

	public void actualizar(Factura fact);

	public void eliminar(Integer id);

	public void insertar(Factura fact);

	public List<Factura> buscarFacturaInnerJoin(LocalDateTime fecha);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterJoin(LocalDateTime fecha);

	public List<Factura> buscarFacturaLeftOuterJoin(LocalDateTime fecha);

	public List<Factura> buscarFacturaLeftOuterJoin();

	public List<Factura> buscarFacturaRightOuterJoin(LocalDateTime fecha);

	public List<Factura> buscarFacturaFetchJoin(LocalDateTime fecha);
}
