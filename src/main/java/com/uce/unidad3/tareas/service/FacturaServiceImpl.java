package com.uce.unidad3.tareas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IClienteRepo;
import com.uce.unidad3.tareas.repository.IFacturaRepo;
import com.uce.unidad3.tareas.repository.IProductoRepo;
import com.uce.unidad3.tareas.repository.modelo.Cliente;
import com.uce.unidad3.tareas.repository.modelo.Datos;
import com.uce.unidad3.tareas.repository.modelo.Detalle;
import com.uce.unidad3.tareas.repository.modelo.Factura;
import com.uce.unidad3.tareas.repository.modelo.Producto;



@Service
public class FacturaServiceImpl implements IFacturaService {
	
	private static Logger logger =  LogManager.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepo factRepo ;
	
	@Autowired
    private IProductoRepo productoRepo;

    @Autowired
    private IClienteRepo clienteRepo;
	@Override
	public Factura buscar(Integer id) {
		
		return this.factRepo.buscar(id);
	}

	

	@Override
	public void actualizar(Factura fact) {
		this.factRepo.actualizar(fact);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.factRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Factura fact) {
		this.factRepo.insertar(fact);
		
	}



	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.factRepo.buscarNumero(numero);
	}

	 // B
	 @Transactional(value = TxType.REQUIRES_NEW)
	 public void actualizarStock(Producto p, Integer cantidad) {
		 p.setStock(p.getStock() - cantidad);
		 this.productoRepo.actualizar(p);
 
	 }
 
	 // metodo
	 @Transactional(value = TxType.REQUIRES_NEW)
	 public Datos productos(String cedulaCliente, String numeroFactura, List<String> codigos) {
		 Cliente cliente = this.clienteRepo.buscarCedula(cedulaCliente);
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
			 Producto p = this.productoRepo.buscarCodigoBarras(cod);
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
		 this.factRepo.insertar(factura);
 
		 Datos d = new Datos();
		 d.setItems(items);
		 d.setMonto(monto);
		 d.setNumeroFactura(numeroFactura);
		 return d;
	 }

}