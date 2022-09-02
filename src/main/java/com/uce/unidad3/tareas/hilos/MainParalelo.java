package com.uce.unidad3.tareas.hilos;
import java.math.BigDecimal;

public class MainParalelo {
    
    public static void main(String[] args) {
        DatosParalelo d1 = new DatosParalelo("11A", new BigDecimal( "1.1"), 30);
        DatosParalelo d2 = new DatosParalelo("11B", new BigDecimal( "1.2"), 40);
        DatosParalelo d3 = new DatosParalelo("11C", new BigDecimal( "1.3"), 50);
        DatosParalelo d4 = new DatosParalelo("11D", new BigDecimal( "1.4"), 60);
        DatosParalelo d5 = new DatosParalelo("11E", new BigDecimal( "1.5"), 80);

        GestorParalelo gestorParalelo = new GestorParalelo(d1);
        GestorParalelo gestorParalelo1 = new GestorParalelo(d2);
        GestorParalelo gestorParalelo2 = new GestorParalelo(d3);
        GestorParalelo gestorParalelo3 = new GestorParalelo(d4);
        GestorParalelo gestorParalelo4 = new GestorParalelo(d5);

        gestorParalelo.start();
        gestorParalelo1.start();
        gestorParalelo2.start();
        gestorParalelo3.start();
        gestorParalelo4.start();

        
        

    }
}
