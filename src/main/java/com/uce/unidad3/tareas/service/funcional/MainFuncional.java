package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uce.unidad3.tareas.repository.modelo.Datos;

public class MainFuncional {

    private static Logger LOG = LogManager.getLogger(MainFuncional.class);
    public static void main(String[] args) {

        List<Datos> lista = new ArrayList<>();
        Datos d1 = new Datos();
        d1.setItems(32);
        d1.setMonto(new BigDecimal("2.2"));
        
        Datos d2 = new Datos();
        d2.setItems(20);
        d2.setMonto(new BigDecimal("1.0"));
        
        Datos d3 = new Datos();
        d3.setItems(25);
        d3.setMonto(new BigDecimal("1.3"));
        
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        
         // SUPPLIER
        
        

        LOG.info("JAVA Supplier");
        Stream<List<Datos>> test = Stream.generate(() -> lista).limit(3).skip(1);
        test.forEach(cadena -> {
            
            LOG.info(cadena);
        
        });

        // CONSUMER
        
       

        LOG.info("JAVA Consumer");
        lista.forEach(dato -> {
            LOG.info("Dato original " + dato.toString());
            dato.setNumeroFactura(" 11A");
            LOG.info("Dato modificado " + dato.toString());
        });
        
        



        // Predicate
        

        LOG.info("JAVA Predicate");
        
        Stream<Datos> nuevaLista =  lista.stream().takeWhile(valor -> valor.getMonto().compareTo(new BigDecimal("2") ) > 0);
        nuevaLista.forEach(d -> LOG.info(d.toString()));
       


        // // FUNCTION
        Set<Datos> set = new HashSet<>(lista);
        
        LOG.info("JAVA Function");
        Long contar = set.stream().map(dato -> dato.getItems()).filter(items -> items > 20).count();
        LOG.info("Datos con items mayores a 20: " + contar);
        



    }
}
