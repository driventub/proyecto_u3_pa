package com.uce.unidad3.tareas.hilos;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestorParalelo extends Thread {
    private static Logger LOG = LogManager.getLogger(GestorParalelo.class);    
    
    private DatosParalelo datos;

    public GestorParalelo(DatosParalelo datos){
        this.datos = datos;
    }


    @Override
    public void run(){
        this.ànalizar(this.datos);
    }
    
    
    public void ànalizar(DatosParalelo datos){
        long tiempoInicial = System.currentTimeMillis();
        LOG.info("Nombre Hilo analizar: " + Thread.currentThread().getName());
        this.atenderCliente(datos.getNumeroFactura());
        long tiempoFinal = System.currentTimeMillis();
        
        long total = (tiempoFinal - tiempoInicial)/1000;
        
        LOG.info("Tiempo transcurrido: " + total + " de la factura: " + datos.getNumeroFactura());
    }

    private void atenderCliente(String cliente) {
        LOG.info("Atendiendo a: " + cliente);
        // Demorar 10 segundos
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 
}
