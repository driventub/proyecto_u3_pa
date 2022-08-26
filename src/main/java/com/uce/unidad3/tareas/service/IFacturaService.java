package com.uce.unidad3.tareas.service;

import java.util.List;

import com.uce.unidad3.tareas.repository.modelo.Datos;
import com.uce.unidad3.tareas.repository.modelo.Factura;
import com.uce.unidad3.tareas.repository.modelo.Producto;

public interface IFacturaService {
    public Factura buscar(Integer id);

    public void actualizar(Factura fact);

    public void eliminar(Integer id);

    public void insertar(Factura fact);

    public Factura buscarNumero(String numero);

    public Datos productos(String cedulaCliente, String numeroFactura, List<String> codigos);

    public void actualizarStock(Producto p, Integer cantidad) ;
}
