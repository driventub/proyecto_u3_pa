package com.uce.unidad3.tareas.service;

import java.util.List;

public interface IGestorService {
    public void crearDetallesFactura(String cedulaCliente, String numeroFactura, List<String> codigos);
 
}
