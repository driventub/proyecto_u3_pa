package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFuncional {

    private static Logger LOG = LogManager.getLogger(MainFuncional.class);
    public static void main(String[] args) {
        
        
        MetodosHighOrder metodos = new MetodosHighOrder();
        
        // Supplier
        // Interfaz

        LOG.info("------------------------------------------------");
        LOG.info("Supplier");
        LOG.info("------------------------------------------------");
        IExamenSupplier<BigDecimal> examenSupplier = new ExamenSupplierImpl();
        LOG.info(examenSupplier.get());

        // Lambda
        IExamenSupplier<BigDecimal> examenSupplierLambda = () -> new BigDecimal("33.33");
        LOG.info(examenSupplierLambda.get());

        // High Order

        LOG.info("El valor es: " + metodos.supplier(examenSupplierLambda, 3));

        // Consumer
        LOG.info("------------------------------------------------");
        LOG.info("Consumer");
        LOG.info("------------------------------------------------");
        // Interfaz

        IExamenConsumer<BigDecimal> examenConsumer = new ExamenConsumerImpl();
        examenConsumer.accept(new BigDecimal("50"));

        // Lambda
        IExamenConsumer<BigDecimal> examenConsumerLambda = arg1 -> LOG.info(arg1 + "\t es de tipo " + arg1.getClass());
        examenConsumerLambda.accept(new BigDecimal("50"));

        // High Order

        metodos.consumer(examenConsumer, 3);

        // Predicate
        LOG.info("------------------------------------------------");
        LOG.info("Predicate");
        LOG.info("------------------------------------------------");
        // Interfaz

        IExamenPredicate<BigDecimal> predicate = new ExamenPredicateImpl();
        LOG.info(predicate.evaluar(new BigDecimal("8.1")));
        // Lambda
        IExamenPredicate<BigDecimal> predicateLambda = arg1 -> {
            Double valor = arg1.doubleValue();
            Boolean cond = false;

            if (valor == 2) {
                cond = true;
            }

            return cond;
        };
        LOG.info(predicateLambda.evaluar(new BigDecimal("8.1")));

        // High Order
        LOG.info(metodos.predicate(predicate, "388"));

        // Function
        LOG.info("------------------------------------------------");
        LOG.info("Function");
        LOG.info("------------------------------------------------");
        // Interfaz

        IExamenFunction<Integer,Boolean> function = new ExamenFunctionImpl();
        LOG.info(function.aplicar(true));
        // Lambda
        IExamenFunction<Integer,Boolean> functionLambda = arg1 -> {
            Integer valor ;
        if (arg1 == true ) {
            valor = 2;
        }else{  
            valor = 3;
        }
        return valor;
        };
        LOG.info(functionLambda.aplicar(true));
        // High Order
        LOG.info("Fecha : " + metodos.function(functionLambda, "texto"));
       
        // Unary
        LOG.info("------------------------------------------------");
        LOG.info("Unary");
        LOG.info("------------------------------------------------");
        // Interfaz
        IExamenUnaryOperator<LocalDateTime> examenUnaryOperator = new ExamenUnaryOperatorImpl();
        LOG.info(examenUnaryOperator.fecha(LocalDateTime.now()));
        // Lambda
        IExamenUnaryOperator<LocalDateTime> unaryOperatorLambda =  arg1 -> arg1.minusYears(50);
        LOG.info(unaryOperatorLambda.fecha(LocalDateTime.now()));
        // High Order
        metodos.unaryOperator(unaryOperatorLambda, 2033, 12, 13);
    }
}
