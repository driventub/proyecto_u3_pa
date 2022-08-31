package com.uce.unidad3.hilos.paralelo;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestorParalelo extends  Thread {

    private CajeroParalelo cajero;

    public GestorParalelo(CajeroParalelo cajero) {
        this.cajero = cajero;
    }

    // Va al que disparar el metodo procesar()

    // Olvidalo, deja sin parametros el run
    // public void run(Cajero cajero){
    //     this.procesar(cajero);
    // }
    @Override
    public void run(){
        this.procesar(this.cajero);
    }
    private static Logger LOG = LogManager.getLogger(GestorParalelo.class);    
    
    public void procesar(CajeroParalelo cajero){
        long tiempoInicial = System.currentTimeMillis();
        LOG.info("Nombre Hilo procesar: " + Thread.currentThread().getName());
        LOG.info("Procesando cajero : " + cajero.getNombre());
        for (String  cliente : cajero.getClientes()) {
            this.atenderCliente(cliente);
        }
        LOG.info("Termino: " + cajero.getNombre());
        long tiempoFinal = System.currentTimeMillis();
        long total = (tiempoFinal - tiempoInicial)/1000;

        LOG.info("Tiempo transcurrido: " + total + " del cajero: " + cajero.getNombre());
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