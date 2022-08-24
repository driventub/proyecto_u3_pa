package com.uce.unidad3.tareas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.modelo.Cliente;
import com.uce.unidad3.tareas.repository.modelo.Datos;
import com.uce.unidad3.tareas.repository.modelo.Detalle;
import com.uce.unidad3.tareas.repository.modelo.Factura;
import com.uce.unidad3.tareas.repository.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IDetalleService detalleService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IFacturaElectronicaService facturaElectronicaService;

    // A
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void crearDetallesFactura(String cedulaCliente, String numeroFactura, List<String> codigos) {

        Datos d = productos(cedulaCliente, numeroFactura, codigos);

        this.facturaElectronicaService.crearFacturaElectronica(d.getNumeroFactura(), d.getMonto(), d.getItems());

    }

    // B

    @Transactional(value = TxType.REQUIRED)
    public void actualizarStock(Producto p, Integer cantidad) {
        p.setStock(p.getStock() - cantidad);
        this.productoService.actualizar(p);

    }

    // metodo
    @Transactional(value = TxType.REQUIRES_NEW)
    private Datos productos(String cedulaCliente, String numeroFactura, List<String> codigos) {
        Cliente cliente = this.clienteService.buscarCedula(cedulaCliente);
        Factura factura = new Factura();

        // Crear Factura
        factura.setCliente(cliente);
        factura.setNumero(numeroFactura);
        factura.setFecha(LocalDateTime.now());

        // Crear Detalles

        BigDecimal monto = new BigDecimal("0");
        Integer items = 0;
        List<Detalle> lista = new ArrayList<>();

        for (String cod : codigos) {
            Detalle detalle = new Detalle();
            detalle.setCantidad(1);
            detalle.setFactura(factura);
            Producto p = this.productoService.buscarCodigoBarras(cod);
            detalle.setProducto(p);
            BigDecimal subtotal = p.getPrecio().multiply(new BigDecimal(detalle.getCantidad()));
            detalle.setSubtotal(subtotal);

            // para ir contando los items que se van agregand al detalle
            items = items + detalle.getCantidad();

            // para el monto total de la factura
            monto = monto.add(subtotal);

            // Impl de funcionalidad B
            actualizarStock(p, detalle.getCantidad());

            lista.add(detalle);
        }

        factura.setMonto(monto);
        factura.setDetalles(lista);
        this.facturaService.insertar(factura);

        Datos d = new Datos();
        d.setItems(items);
        d.setMonto(monto);
        d.setNumeroFactura(numeroFactura);
        return d;
    }



}
