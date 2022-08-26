package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;

public class ExamenPredicateImpl implements IExamenPredicate<BigDecimal>{

    @Override
    public boolean evaluar(BigDecimal arg1) {
        Double valor = arg1.doubleValue();
        Boolean cond = false;

        if(valor == 2){
            cond = true;
        }

        return cond;
    }
    
}
