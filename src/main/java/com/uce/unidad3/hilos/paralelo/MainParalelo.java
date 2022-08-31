package com.uce.unidad3.hilos.paralelo;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainParalelo {
    private static Logger LOG = LogManager.getLogger(MainParalelo.class);
    public static void main(String[] args) {
        long tiempoInicial = System.currentTimeMillis();

        LOG.info("Nombre Hilo : " + Thread.currentThread().getName());
        CajeroParalelo cajero1 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
        CajeroParalelo cajero2 = new CajeroParalelo("Paul", Arrays.asList("Pepito2"));
        CajeroParalelo cajero3 = new CajeroParalelo("Luis", Arrays.asList("Pepito3"));

        CajeroParalelo cajero5 = new CajeroParalelo("Edison", Arrays.asList("Juan"));
        CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList("Juan2"));
        CajeroParalelo cajero8 = new CajeroParalelo("Luis", Arrays.asList("Juan3"));

        
        // CajeroParalelo cajero1 = new CajeroParalelo("Edison", Arrays.asList("Pepito" ,"Juan", "Daniela", "Pedro"));
        // CajeroParalelo cajero2 = new CajeroParalelo("Paul", Arrays.asList("Pepito2" ,"Juan2", "Daniela2", "Pedro2"));
        // CajeroParalelo cajero3 = new CajeroParalelo("Luis", Arrays.asList("Pepito3" ,"Juan3", "Daniela3", "Pedro3"));

        
        GestorParalelo gestorCajero = new GestorParalelo(cajero3);
        GestorParalelo gestorCajero2 = new GestorParalelo(cajero2);
        GestorParalelo gestorCajero1 = new GestorParalelo(cajero1);
        GestorParalelo gestorCajero5 = new GestorParalelo(cajero5);
        GestorParalelo gestorCajero6 = new GestorParalelo(cajero6);
        GestorParalelo gestorCajero8 = new GestorParalelo(cajero8);
        gestorCajero1.start();
        gestorCajero2.start();
        gestorCajero.start();
        gestorCajero5.start();
        gestorCajero6.start();
        gestorCajero8.start();

        long tiempoFinal = System.currentTimeMillis();
        long total = (tiempoFinal - tiempoInicial)/1000;

        LOG.info("Tiempo transcurrido: " + total );
    }
}
