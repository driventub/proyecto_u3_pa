package com.uce.unidad3.tareas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.unidad3.tareas.repository.modelo.Factura;

public interface IFacturaService {
    public Factura buscar(Integer id);

    public void actualizar(Factura fact);

    public void eliminar(Integer id);

    public void insertar(Factura fact);

    public Factura buscarNumero(String numero);
}
