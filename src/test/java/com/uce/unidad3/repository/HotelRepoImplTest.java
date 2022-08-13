package com.uce.unidad3.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.unidad3.repository.modelo.Hotel;

@SpringBootTest
@Rollback(true)
@Transactional
public class HotelRepoImplTest {

    @Autowired
    private IHotelRepo hotelRepo;

    @Test
    void testEliminar() {
        Integer id = 1;
		Hotel hotelInicio = hotelRepo.buscar(id);
		hotelRepo.eliminar(id);
		Hotel hotelFin = hotelRepo.buscar(id);
		assertNotNull(hotelInicio);
		assertNull(hotelFin);
    }
}
