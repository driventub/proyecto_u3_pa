package com.uce.unidad3.hilos.traditional;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestorCajero {
    private static Logger LOG = LogManager.getLogger(GestorCajero.class);    
    
    public void procesar(Cajero cajero){
        LOG.info("Nombre Hilo procesar: " + Thread.currentThread().getName());
        LOG.info("Procesando cajero : " + cajero.getNombre());
        for (String  cliente : cajero.getClientes()) {
            atenderCliente(cliente);
        }
        
    }

    private void atenderCliente(String cliente) {
        LOG.info("Atendiendo a: " + cliente);
        // Demorar 10 segundos
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
