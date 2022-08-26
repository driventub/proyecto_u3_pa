package com.uce.unidad3;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.unidad3.tareas.service.IGestorService;

@SpringBootApplication
public class Unidad3Application implements CommandLineRunner{

	private static Logger LOG =  LogManager.getLogger(Unidad3Application.class);

	@Autowired
	private IGestorService gestorService;


	public static void main(String[] args) {
		SpringApplication.run(Unidad3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	// // En teoria segun yo, aqui irian los unico valores a parte del metodo, ya que representarian
	// // los productos que se escanean
	List<String> codigos = new ArrayList<>();
	codigos.add("111");
	codigos.add("112");
	codigos.add("113");

	this.gestorService.crearDetallesFactura("170383657-2", "2022Factura", codigos);
	
	
	}

}