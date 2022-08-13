package com.uce.unidad3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.unidad3.repository.IHotelRepo;
import com.uce.unidad3.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

    private static Logger LOG = LogManager.getLogger(HotelServiceImpl.class);

    @Autowired
    private IHotelRepo hoteRepo;

    @Override
    public List<Hotel> buscarHotelInnerJoin(String habitacion) {

        return this.hoteRepo.buscarHotelInnerJoin(habitacion);
    }

    @Override
    public List<Hotel> buscarHotelOuterJoin(String habitacion) {

        return this.hoteRepo.buscarHotelOuterJoin(habitacion);
    }

    @Override
    public List<Hotel> buscarHotelLeftOuterJoin(String habitacion) {

        return this.hoteRepo.buscarHotelLeftOuterJoin(habitacion);
    }

    @Override
    public List<Hotel> buscarHotelRightOuterJoin(String habitacion) {

        return this.hoteRepo.buscarHotelRightOuterJoin(habitacion);
    }

    @Override
    public List<Hotel> buscarHotelFetchJoin(String habitacion) {
        LOG.info("Transaccion Activa" + TransactionSynchronizationManager.isActualTransactionActive());
        return this.hoteRepo.buscarHotelFetchJoin(habitacion);
    }

    @Override
    public List<Hotel> buscarHotelInnerJoin() {
        
        return this.hoteRepo.buscarHotelInnerJoin();
    }

    @Override
    public List<Hotel> buscarHotelLeftOuterJoin() {
        
        return this.hoteRepo.buscarHotelLeftOuterJoin();
    }

    @Override
    public List<Hotel> buscarHotelWhereJoin(String tipo) {
        // TODO Auto-generated method stub
        return this.hoteRepo.buscarHotelWhereJoin(tipo);
    }

    
	@Override
	public Hotel buscar(Integer id) {
		
		return this.hoteRepo.buscar(id);
	}

	@Override
	public List<Hotel> buscarTodos() {
		
		return this.hoteRepo.buscarTodos();
	}

	@Override
	public Hotel actualizar(Hotel hote) {
		return this.hoteRepo.actualizar(hote);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.hoteRepo.eliminar(id);
		
	}

	@Override
	public Hotel insertar(Hotel hote) {
		return this.hoteRepo.insertar(hote);
		
	}

}