package com.uce.unidad3.tareas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IFacturaRepo;
import com.uce.unidad3.tareas.repository.modelo.Factura;



@Service
public class FacturaServiceImpl implements IFacturaService {
	
	private static Logger logger =  LogManager.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepo factRepo ;
	
	@Override
	public Factura buscar(Integer id) {
		
		return this.factRepo.buscar(id);
	}

	@Override
	public List<Factura> buscarTodos() {
		
		return this.factRepo.buscarTodos();
	}

	@Override
	public void actualizar(Factura fact) {
		this.factRepo.actualizar(fact);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.factRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Factura fact) {
		this.factRepo.insertar(fact);
		
	}

    @Override
    public List<Factura> buscarFacturaInnerJoin(LocalDateTime fecha) {

        return this.factRepo.buscarFacturaInnerJoin(fecha);
    }

    @Override
    public List<Factura> buscarFacturaOuterJoin(LocalDateTime fecha) {

        return this.factRepo.buscarFacturaOuterJoin(fecha);
    }

    @Override
    public List<Factura> buscarFacturaLeftOuterJoin(LocalDateTime fecha) {

        return this.factRepo.buscarFacturaLeftOuterJoin(fecha);
    }

    @Override
    public List<Factura> buscarFacturaRightOuterJoin(LocalDateTime fecha) {

        return this.factRepo.buscarFacturaRightOuterJoin(fecha);
    }

    @Override
    public List<Factura> buscarFacturaFetchJoin(LocalDateTime fecha) {

        return this.factRepo.buscarFacturaFetchJoin(fecha);
    }

    @Override
    public List<Factura> buscarFacturaInnerJoin() {
        
        return this.factRepo.buscarFacturaInnerJoin();
    }

    @Override
    public List<Factura> buscarFacturaLeftOuterJoin() {
        
        return this.factRepo.buscarFacturaLeftOuterJoin();
    }

    @Override
    public List<Factura> buscarFacturaWhereJoin(LocalDateTime fecha) {
        // TODO Auto-generated method stub
        return this.factRepo.buscarFacturaWhereJoin(fecha);
    }
}