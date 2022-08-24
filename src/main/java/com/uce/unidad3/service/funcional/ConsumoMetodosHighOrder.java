package com.uce.unidad3.service.funcional;

public class ConsumoMetodosHighOrder {

    public String consumirSupplier(IPersonaSupplier<String> funcion) {
        // String valor = funcion.getNombre();
        // Integer valorMInteger = Integer .parseInt(valor);
        // return valorMInteger;
        return funcion.getNombre() + " se proceso el dato";
    }

    public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
        funcion.accept(valor);
    }

    public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
        return funcion.evaluar(valor);
    }

    public String consumirFunction(IPersonaFunction<String,Integer> funcion, Integer valor) {
        return funcion.applicar(valor);
    }

    public String consumirUnary(IPersonaUnaryOperator<String> funcion) {
        return null;
    }
}
