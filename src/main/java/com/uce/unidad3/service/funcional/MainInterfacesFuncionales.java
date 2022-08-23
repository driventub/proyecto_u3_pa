package com.uce.unidad3.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfacesFuncionales {
    public static void main(String[] args) {

        final Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);
        // SUPPLIER
        // Clase
        IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
        LOG.info("Supplier Clase: "+ supplier.getNombre());


        IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
        LOG.info("Supplier Clase: "+ supplierTE.getNombre());
        // Lambda
        IPersonaSupplier<String> supplierLambda = () -> "P2Lambda";
        LOG.info("Supplier Lambda: "+ supplierLambda.getNombre());
        
        IPersonaSupplier<String> supplierLambdaTE = () -> "TE DanielLambda";
        LOG.info("Supplier Lambda: "+ supplierLambdaTE.getNombre());
        
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

        // FUNCTION
        // Clase
        // Lambda

        // UNARYOPERATOR
        // Clase
        // Lambda
    }
    
}
