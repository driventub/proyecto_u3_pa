package com.uce.unidad3.tareas.repository;

import com.uce.unidad3.tareas.repository.modelo.Cliente;

public interface IClienteRepo {
    public Cliente buscar(Integer id);

    public void actualizar(Cliente clie);

    public void eliminar(Integer id);

    public void insertar(Cliente clie);

    public Cliente buscarCedula(String cedula);
}
