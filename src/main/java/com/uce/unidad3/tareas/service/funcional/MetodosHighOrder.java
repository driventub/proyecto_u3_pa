package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MetodosHighOrder {

    private static Logger LOG = LogManager.getLogger(MetodosHighOrder.class);

    public String supplier(IExamenSupplier<BigDecimal> examenSupplier, Integer valor) {
        BigDecimal num = examenSupplier.get().add(new BigDecimal(valor));
        return num.toEngineeringString();
    }

    public void consumer(IExamenConsumer<BigDecimal> examenConsumer, Integer valor) {
        LOG.info("Programa para ver las clases");
        examenConsumer.accept(new BigDecimal(valor));
        
    }

    public String predicate(IExamenPredicate<BigDecimal> examenPredicate, String valor){
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        String algo = "";
        if (examenPredicate.evaluar(valorBigDecimal) == true) {
            algo = "El numero tiene 2 decimales";
        }else{
            algo = "El numero no tiene 2 decimales";
        }

        return algo;
    }

    public LocalDateTime function(IExamenFunction<Integer, Boolean> examenFunction, String texto ) {
        Integer valor = texto.length();
        Boolean condMayor = valor > 0;
        Boolean condMenor = valor < 12;
        

        LocalDateTime fecha =null;
        if(condMayor == true && condMenor == true){
            fecha = LocalDateTime.of(2022, valor, 1, 1, 1, 1);
        }
        
        return fecha;
    }

    public void unaryOperator(IExamenUnaryOperator<LocalDateTime> examenUnaryOperator, Integer anho, Integer mes, Integer dia){
        LOG.info("Hace 50 años seria : " + examenUnaryOperator.fecha(LocalDateTime.of(anho, mes, dia, 1, 1, 1)));
    }

}
