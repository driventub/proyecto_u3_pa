package com.uce.unidad3.tareas.service.funcional;

public class ExamenFunctionImpl implements IExamenFunction<Integer, Boolean>{

    @Override
    public Integer aplicar(Boolean arg1) {
        Integer valor ;
        if (arg1 == true ) {
            valor = 2;
        }else{  
            valor = 3;
        }
        return valor;
    }
    
}
