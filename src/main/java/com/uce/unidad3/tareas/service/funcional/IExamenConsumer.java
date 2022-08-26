package com.uce.unidad3.tareas.service.funcional;

@FunctionalInterface
public interface IExamenConsumer<T> {
    public void accept(T arg1);
}
