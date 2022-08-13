package com.uce.unidad3;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.unidad3.service.ITransferenciaService;

@SpringBootApplication
public class Unidad3Application implements CommandLineRunner{

	private static Logger LOG =  LogManager.getLogger(Unidad3Application.class);

	
	@Autowired
	private ITransferenciaService transferenciaService;


	// @Autowired
	// private IHotelService hotelService;

	
	public static void main(String[] args) {
		SpringApplication.run(Unidad3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this.transferenciaService.realizarTransferenciaFachada("22342", "83828", new BigDecimal("12.00"));
	
	
		

	}

}