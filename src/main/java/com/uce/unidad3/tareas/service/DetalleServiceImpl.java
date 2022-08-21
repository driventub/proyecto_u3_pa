package com.uce.unidad3.tareas.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IDetalleRepo;
import com.uce.unidad3.tareas.repository.modelo.Detalle;

@Service
public class DetalleServiceImpl implements IDetalleService {

    private static Logger logger = LogManager.getLogger(DetalleServiceImpl.class);

    @Autowired
    private IDetalleRepo detaRepo;

    @Override
    public Detalle buscar(Integer id) {

        return this.detaRepo.buscar(id);
    }


    @Override
    public void actualizar(Detalle deta) {
        this.detaRepo.actualizar(deta);

    }

    @Override
    public void eliminar(Integer id) {
        this.detaRepo.eliminar(id);

    }

    @Override
    public void insertar(Detalle deta) {
        this.detaRepo.insertar(deta);

    }

}
