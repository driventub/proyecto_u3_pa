package com.uce.unidad3.hilos.traditional;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(GestorCajero.class);    
    public static void main(String[] args) {

        long tiempoInicial = System.currentTimeMillis();
        Cajero cajero1 = new Cajero("Edison", Arrays.asList("Pepito" ,"Juan", "Daniela", "Pedro"));
        Cajero cajero2 = new Cajero("Paul", Arrays.asList("Pepito2" ,"Juan2", "Daniela2", "Pedro2"));
        Cajero cajero3 = new Cajero("Luis", Arrays.asList("Pepito3" ,"Juan3", "Daniela3", "Pedro3"));

        GestorCajero gestorCajero = new GestorCajero();
        gestorCajero.procesar(cajero1);
        gestorCajero.procesar(cajero2);
        gestorCajero.procesar(cajero3);
        long tiempoFinal = System.currentTimeMillis();
        long total = (tiempoFinal - tiempoInicial)/1000;

        LOG.info("Tiempo transcurrido: " + total );

    }
}
