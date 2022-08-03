package com.uce.unidad3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.repository.IHotelRepo;
import com.uce.unidad3.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

    private static Logger logger = LogManager.getLogger(HotelServiceImpl.class);

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
}