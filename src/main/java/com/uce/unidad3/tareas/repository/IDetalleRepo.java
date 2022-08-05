package com.uce.unidad3.tareas.repository;

import java.util.List;

import com.uce.unidad3.tareas.repository.modelo.Detalle;

public interface IDetalleRepo {
    public Detalle buscar(Integer id);

    public List<Detalle> buscarTodos();

    public void actualizar(Detalle deta);

    public void eliminar(Integer id);

    public void insertar(Detalle deta);
}
