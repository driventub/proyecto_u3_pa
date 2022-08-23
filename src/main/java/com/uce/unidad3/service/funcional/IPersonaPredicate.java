package com.uce.unidad3.service.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
    public boolean accept(T arg1);
}
