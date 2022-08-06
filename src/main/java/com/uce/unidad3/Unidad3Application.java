package com.uce.unidad3;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.unidad3.repository.modelo.Habitacion;
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

		// LOG.info("WHERE");
		// List<Hotel> lista = this.hotelService.buscarHotelWhereJoin("Familiar");

		// for (Hotel hotel : lista) {
		// 	LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
		// }

		LOG.info("Inner JOIN Eager/Lazy");

		List<Hotel> lista1 = this.hotelService.buscarHotelInnerJoin("Familiar");

		for (Hotel hotel : lista1) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				LOG.info("Numero: "+ habitacion.getNumero());
			}
		}

		LOG.info("Fetch JOIN");
		List<Hotel> lista2 = this.hotelService.buscarHotelFetchJoin("Familiar");

		for (Hotel hotel : lista2) {
			LOG.info("Hotel: " + hotel.getNombre() + " " + "Direccion: " + hotel.getDireccion());
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				LOG.info("ID:"+ habitacion.getId() + "Numero: "+ habitacion.getNumero());
			}
		}

	}

}
