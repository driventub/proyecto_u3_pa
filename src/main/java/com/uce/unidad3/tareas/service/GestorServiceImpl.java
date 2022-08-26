package com.uce.unidad3.tareas.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.modelo.Datos;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IFacturaElectronicaService facturaElectronicaService;

    // A
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void crearDetallesFactura(String cedulaCliente, String numeroFactura, List<String> codigos) {

        Datos d = this.facturaService.productos(cedulaCliente, numeroFactura, codigos);

        this.facturaElectronicaService.crearFacturaElectronica(d.getNumeroFactura(), d.getMonto(), d.getItems());

    }


}
