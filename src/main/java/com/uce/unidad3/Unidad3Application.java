package com.uce.unidad3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.unidad3.tareas.repository.modelo.Detalle;
import com.uce.unidad3.tareas.repository.modelo.Factura;
import com.uce.unidad3.tareas.service.IDetalleService;
import com.uce.unidad3.tareas.service.IFacturaService;

@SpringBootApplication
public class Unidad3Application implements CommandLineRunner{

	private static Logger LOG =  LogManager.getLogger(Unidad3Application.class);

	@Autowired
	private IFacturaService factService;

	@Autowired
	private IDetalleService detalleService;

	public static void main(String[] args) {
		SpringApplication.run(Unidad3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Factura f= new Factura();
		
		// f.setNumero("q11");
		// f.setFecha(LocalDateTime.of(2022, 10, 01, 01, 01));
		
		// this.factService.insertar(f);

		
		// Factura f1= new Factura();
		
		// f1.setNumero("q10");
		// f1.setFecha(LocalDateTime.of(2021, 10, 01, 01, 01));
		
		// this.factService.insertar(f1);

		
		// Factura f2= new Factura();
		
		// f2.setNumero("q13");
		// f2.setFecha(LocalDateTime.of(2021, 10, 01, 01, 01));
		
		// this.factService.insertar(f2);

		



		// Detalle d1 = new Detalle();

		// d1.setCantidad(23);
		// d1.setNombre("Coca Cola");
		// d1.setSubtotal(new BigDecimal("23"));
		// d1.setFactura(f1);

		// Detalle d2 = new Detalle();

		// d2.setCantidad(32);
		// d2.setNombre("Pepsi");
		// d2.setSubtotal(new BigDecimal("32"));
		// d2.setFactura(f1);
		
		// Detalle d3 = new Detalle();

		// d3.setCantidad(22);
		// d3.setNombre("Fioravanti");
		// d3.setSubtotal(new BigDecimal("22"));
		// d3.setFactura(f1);

		// Detalle d4 = new Detalle();

		// d4.setNombre("Inca Cola");
		// d4.setCantidad(52);
		// d4.setSubtotal(new BigDecimal("52"));
		// d4.setFactura(f2);

		// Detalle d5 = new Detalle();

		// d5.setNombre("Fanta");
		// d5.setCantidad(26);
		// d5.setSubtotal(new BigDecimal("26"));
		// d5.setFactura(f2);

		
		// Detalle d6 = new Detalle();

		// d6.setNombre("Sprite");
		// d6.setCantidad(3);
		// d6.setSubtotal(new BigDecimal("3"));
		// d6.setFactura(f);

		

		

		// this.detalleService.insertar(d1);
		// this.detalleService.insertar(d2);
		// this.detalleService.insertar(d3);
		// this.detalleService.insertar(d4);
		// this.detalleService.insertar(d5);
		// this.detalleService.insertar(d6);



		// Inner

		LOG.info("Inner");
		List<Factura> lista = this.factService.buscarFacturaInnerJoin(LocalDateTime.of(2022,10,10,01,01));
		
		for (Factura fact : lista) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		// Outer
		LOG.info("Outer");
		List<Factura> lista2 = this.factService.buscarFacturaOuterJoin(LocalDateTime.of(2022,10,10,01,01));
		
		for (Factura fact : lista2) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		
		// Left
		LOG.info("Left");
		List<Factura> lista3 = this.factService.buscarFacturaLeftOuterJoin(LocalDateTime.of(2022,10,10,01,01));
		
		for (Factura fact : lista3) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		
		// Right
		LOG.info("Right");
		List<Factura> lista4 = this.factService.buscarFacturaRightOuterJoin(LocalDateTime.of(2022,10,10,01,01));
		
		for (Factura fact : lista4) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		
		// Inner 2
		LOG.info("Inner 2");
		List<Factura> lista6 = this.factService.buscarFacturaInnerJoin();
		
		for (Factura fact : lista6) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		
		// Left 2
		LOG.info("Left 2");
		List<Factura> lista7 = this.factService.buscarFacturaLeftOuterJoin();
		
		for (Factura fact : lista7) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero()+ fact.getDetalles().toString());
		}
		
	}

}
