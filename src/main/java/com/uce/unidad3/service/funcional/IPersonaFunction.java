package com.uce.unidad3.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> {
    R applicar(T arg1);
}
