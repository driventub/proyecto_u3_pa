package com.uce.unidad3.service.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
       public T getNombre();
}
