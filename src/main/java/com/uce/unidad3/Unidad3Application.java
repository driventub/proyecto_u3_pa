package com.uce.unidad3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uce.unidad3.repository.modelo.Hotel;
import com.uce.unidad3.service.IHotelService;

@SpringBootApplication
public class Unidad3Application implements CommandLineRunner{

	private static Logger LOG =  LogManager.getLogger(Unidad3Application.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Unidad3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inner
		List<Hotel> lista = this.hotelService.buscarHotelInnerJoin("Familiar");
		
		for (Hotel hotel : lista) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		// Outer
		List<Hotel> lista2 = this.hotelService.buscarHotelOuterJoin("Familiar");
		
		for (Hotel hotel : lista2) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		
		// Left
		List<Hotel> lista3 = this.hotelService.buscarHotelLeftOuterJoin("Familiar");
		
		for (Hotel hotel : lista3) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		
		// Right
		List<Hotel> lista4 = this.hotelService.buscarHotelRightOuterJoin("Familiar");
		
		for (Hotel hotel : lista4) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		
		// Inner 2
		List<Hotel> lista6 = this.hotelService.buscarHotelInnerJoin();
		
		for (Hotel hotel : lista6) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		
		// Left 2
		List<Hotel> lista7 = this.hotelService.buscarHotelLeftOuterJoin();
		
		for (Hotel hotel : lista7) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		}
		
	}

}
