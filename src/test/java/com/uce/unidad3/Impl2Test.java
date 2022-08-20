package com.uce.unidad3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.unidad3.repository.IHotelRepo;
import com.uce.unidad3.repository.modelo.Hotel;
import com.uce.unidad3.service.IHotelService;

@SpringBootTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)//indica que me haga las operaciones a la base de datos real
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(true)
@Transactional
class Impl2Test {
    
    private static Logger LOG =  LogManager.getLogger(HotelServiceTest.class);
    
    @Autowired
    private IHotelRepo hotelRepo;
    
    @Mock
    private IHotelRepo hotelRepo2;
    
    @Autowired
    private IHotelService hotelService;
    
    @Test
    @Order(1)
    public void testGuardarHotel() {
        LOG.info("Test guardar hotel 1");
        Hotel hotel= new Hotel();
        hotel.setNombre("angel7");
        hotel.setDireccion("san luis7");
        
        Hotel hotelGuardado =  this.hotelRepo.insertar(hotel);
        
        assertNotNull(hotelGuardado);//me va a confirmar la prueba simpre y cuando no sea nulo
    }
    
    @Test
    @Order(3)
    public void testBuscarHotel() {
        LOG.info("Test buscar hotel 3");
        Integer id = 2;
        Hotel hotel = this.hotelRepo.buscar(id);
           
        assertThat(hotel.getId()).isEqualTo(id);
    }


    @Test
    @Order(2)
    public void buscarHotelLeftOuterJoinTest() {
        LOG.info("Test buscarHotelLeftOuterJoinTest hotel 2");
        
        Hotel hotel= new Hotel();
        hotel.setNombre("Gran Colon");
        hotel.setDireccion("Patria");
        
        
        when(this.hotelRepo2.buscarHotelLeftOuterJoin("Familiar")).thenReturn(Arrays.asList(hotel));
        assertNotNull(hotelService.buscarHotelLeftOuterJoin());
        
    }
    
    @Test
    @Order(5)
    public void actualizarHotelTest() {
        LOG.info("Test actualizar hotel 5");
        Integer id = 3;
        
        Hotel hotel= new Hotel();
        hotel.setNombre("marco1");
        hotel.setDireccion("calle 21 A1");
        hotel.setId(id);
        
        Hotel hotelActualizado =  this.hotelRepo.actualizar(hotel);
        
        assertThat(hotelActualizado.getId()).isEqualTo(id);//confirmo si el proidcuto actulizado
    }
    
    @Test
    @Order(4)
    public void  testbuscarHotelLeftOuterJoin()  {
        LOG.info("Test buscarHotelLeftOuterJoin hotel 4");
        List<Hotel> hoteles = this.hotelRepo.buscarHotelLeftOuterJoin();
        for(Hotel hotel: hoteles) {
            System.out.println(hotel);
        }
        
        assertThat(hoteles).size().isGreaterThan(0);//si el tamño de la lista es mayor que cero
    }
    
    
}

