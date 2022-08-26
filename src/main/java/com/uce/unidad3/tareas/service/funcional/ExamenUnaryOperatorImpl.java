package com.uce.unidad3.tareas.service.funcional;

import java.time.LocalDateTime;

public class ExamenUnaryOperatorImpl implements  IExamenUnaryOperator<LocalDateTime>{

    @Override
    public LocalDateTime fecha(LocalDateTime arg1) {
        
        return arg1.minusYears(50);
    }
    
}
