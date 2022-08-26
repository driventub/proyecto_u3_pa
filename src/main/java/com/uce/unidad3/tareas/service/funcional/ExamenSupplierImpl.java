package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;

public class ExamenSupplierImpl implements IExamenSupplier<BigDecimal>{

    @Override
    public BigDecimal get() {
        
        return new BigDecimal("33.33");
    }
    
}
