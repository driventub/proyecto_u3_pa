package com.uce.unidad3.tareas.service.funcional;

@FunctionalInterface
public interface IExamenPredicate<T> {
    public boolean evaluar(T arg1);
}