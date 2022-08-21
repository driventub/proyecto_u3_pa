package com.uce.unidad3.tareas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IClienteRepo;
import com.uce.unidad3.tareas.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

    private static Logger LOG = LogManager.getLogger(ClienteServiceImpl.class);

    @Autowired
    private IClienteRepo clieRepo;

    @Override
    public Cliente buscar(Integer id) {

        return this.clieRepo.buscar(id);
    }

    @Override
    public void actualizar(Cliente clie) {
        this.clieRepo.actualizar(clie);

    }

    @Override
    public void eliminar(Integer id) {
        this.clieRepo.eliminar(id);

    }

    @Override
    public void insertar(Cliente clie) {
        this.clieRepo.insertar(clie);

    }

    @Override
    public Cliente buscarCedula(String cedula) {
        
        return this.clieRepo.buscarCedula(cedula);
    }

}
