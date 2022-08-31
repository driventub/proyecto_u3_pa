package com.uce.unidad3.hilos.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainStreamParalelo {
    private static Logger LOG = LogManager.getLogger(MainStreamParalelo.class);
    public static void main(String[] args) {
        
        long tiempoInicial = System.currentTimeMillis();

        List<Integer> listaNumeroAlumnos = new ArrayList<>();
        for (int i = 1; i < 5000; i++) {
            listaNumeroAlumnos.add(i);
        }

        // collect para convertir a una lista , usar map para pasar de un tipo a otro
        List<String> listaConvertida = listaNumeroAlumnos.parallelStream().map(numero -> convertirIdAlumno(numero))
                .collect(Collectors.toList());

        listaConvertida.forEach(cadena -> LOG.info(cadena));

        long tiempoFinal = System.currentTimeMillis();
        long total = (tiempoFinal - tiempoInicial)/1000;

        LOG.info("Tiempo transcurrido: " + total );
    }

    private static String convertirIdAlumno(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "ID: " + id.toString();
    }
    
}   
