package com.uce.unidad3.tareas.service;

import com.uce.unidad3.tareas.repository.modelo.Producto;

public interface IProductoService {
    public Producto buscar(Integer id);

    public void actualizar(Producto prod);

    public void eliminar(Integer id);

    public void insertar(Producto prod);

    public Producto buscarCodigoBarras(String codigoBarras);
}
