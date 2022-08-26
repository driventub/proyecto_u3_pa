package com.uce.unidad3.tareas.service.funcional;

@FunctionalInterface
public interface IExamenFunction<R,T> {
    R aplicar(T arg1);
}