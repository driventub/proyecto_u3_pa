package com.uce.unidad3;

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
import com.uce.unidad3.tareas.service.IFacturaService;

@SpringBootApplication
public class Unidad3Application implements CommandLineRunner{

	private static Logger LOG =  LogManager.getLogger(Unidad3Application.class);

	
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Unidad3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Inner");
		List<Factura> listaW = this.facturaService.buscarFacturaWhereJoin(LocalDateTime.of(2022,10,10,01,01));

		for (Factura fact : listaW) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero());
		}

		List<Factura> listaF = this.facturaService.buscarFacturaFetchJoin(LocalDateTime.of(2022,10,10,01,01));

		for (Factura fact : listaF) {
			LOG.info("Factura: "  + "Numero: " + fact.getNumero());
			for (Detalle detalle : fact.getDetalles()) {
				LOG.info("Producto: " + detalle.getNombre());
			}
		}

		
	}
}
