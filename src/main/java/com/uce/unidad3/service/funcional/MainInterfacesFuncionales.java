package com.uce.unidad3.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {  
    
    public static final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);

    public static boolean prueba (Integer i){
        return i >= 3;
    }

    public static void imprimir(String cadena){
        LOG.info(cadena);
    }

    public static void guardar(String insertar){
        // Consumo de valores 
    }

    public static void main(String[] args) {

        ConsumoMetodosHighOrder metodoHO = new ConsumoMetodosHighOrder();

        
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

        LOG.info("JAVA Supplier");
        Stream<String> test = Stream.generate(()-> "Edison 3").limit(7);
        test.forEach(cadena -> LOG.info(cadena));

        // CONSUMER
        // Clase
        IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
        consumer.accept("Prueba Consumer");
        List<Integer> lista = Arrays.asList(1,2,3,4,5);
        LOG.info("JAVA Consumer");
        lista.forEach(numero -> LOG.info(numero));

        // Lambda
        IPersonaConsumer<String> consumerLambda = cadena -> LOG.info(cadena);
        consumerLambda.accept("Prueba Consumer Lambda");

        // PREDICATE
        // Clase

        // Lambda

        IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("F");
        LOG.info(predicateLambda.evaluar("Equals"));

        LOG.info("JAVA Predicate");
        Stream<Integer> nuevaLista =  lista.stream().filter(valor -> prueba(valor));
        nuevaLista.forEach(numero -> LOG.info(numero));


        // FUNCTION
        // Clase
        // Lambda
        IPersonaFunction<Integer, String> functionLambda = cadena -> {
            Integer valor = Integer.parseInt(cadena) + 2;
            Integer valorFinal = valor - 2;
            return valorFinal;
        };
        LOG.info(functionLambda.applicar("2"));


        LOG.info("JAVA Function");
        Stream<String> listaCambiada = lista.stream().map(numeroLista -> {
            Integer valor = numeroLista + 1;
            String cadena = "num: " + valor.toString();
            return cadena;
        });

        listaCambiada.forEach(valor -> imprimir(valor));


        List<String> lista1 = new ArrayList<>();
        Map<String,String> mpa1 = new HashMap<String, String>();
        


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

        
        // Streams
        // Supplier
       

        // Consumer
       


    }

}
