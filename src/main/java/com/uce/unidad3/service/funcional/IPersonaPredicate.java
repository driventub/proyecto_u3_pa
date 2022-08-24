package com.uce.unidad3.service.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
    public boolean evaluar(T arg1);
}
