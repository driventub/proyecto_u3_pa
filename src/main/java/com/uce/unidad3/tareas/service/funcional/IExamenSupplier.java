package com.uce.unidad3.tareas.service.funcional;

@FunctionalInterface
public interface IExamenSupplier<T> {
       public T get();
}