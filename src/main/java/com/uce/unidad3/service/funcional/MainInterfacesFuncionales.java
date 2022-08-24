package com.uce.unidad3.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {
    public static void main(String[] args) {

        ConsumoMetodosHighOrder metodoHO = new ConsumoMetodosHighOrder();

        final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);
        // SUPPLIER
        // Clase
        IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
        LOG.info("Supplier Clase: " + supplier.getNombre());

        IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
        LOG.info("Supplier Clase: " + supplierTE.getNombre());
        // Lambda
        IPersonaSupplier<String> supplierLambda = () -> "P2Lambda";
        LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

        IPersonaSupplier<String> supplierLambdaTE = () -> "TE DanielLambda";
        LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());

        // CONSUMER
        // Clase
        IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
        consumer.accept("Prueba Consumer");

        // Lambda
        IPersonaConsumer<String> consumerLambda = cadena -> LOG.info(cadena);
        consumerLambda.accept("Prueba Consumer Lambda");

        // PREDICATE
        // Clase

        // Lambda

        IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("F");
        LOG.info(predicateLambda.evaluar("Equals"));

        // FUNCTION
        // Clase
        // Lambda
        IPersonaFunction<Integer, String> functionLambda = cadena -> {
            Integer valor = Integer.parseInt(cadena) + 2;
            Integer valorFinal = valor - 2;
            return valorFinal;
        };
        LOG.info(functionLambda.applicar("2"));

        // UNARYOPERATOR
        // Clase
        // Lambda
        IPersonaUnaryOperator<String> unaryLambda = cade -> {
            String valorFinal = cade.concat("algo");
            return valorFinal;
        };
        LOG.info(unaryLambda.convertir("mas "));

        // Metodos HighOrder

        LOG.info("High Order Supplier :" + metodoHO.consumirSupplier(() -> {
            String valorConsultado = "124782";
            return valorConsultado;
        } ));

        
        metodoHO.consumirConsumer(valor -> LOG.info(valor) , 2);
        
        LOG.info("High Order Predicate : " + metodoHO.consumirPredicate(cadena -> cadena.contains("Z") ,"Algo"));
        LOG.info("High Order Predicate : " + metodoHO.consumirPredicate(cadena -> cadena.contains("Z") ,"Algo"));

        LOG.info("High Order Function : " + metodoHO.consumirFunction(valor -> {
            String r = valor.toString() + "A";
            return r;
        },2));

        

    }

}
