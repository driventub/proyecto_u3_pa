package com.uce.unidad3.service;

import java.util.List;

import com.uce.unidad3.repository.modelo.Hotel;

public interface IHotelService {
    public List<Hotel> buscarHotelInnerJoin(String habitacion);

    public List<Hotel> buscarHotelInnerJoin();

    public List<Hotel> buscarHotelOuterJoin(String habitacion);

    public List<Hotel> buscarHotelLeftOuterJoin(String habitacion);

    public List<Hotel> buscarHotelLeftOuterJoin();

    public List<Hotel> buscarHotelRightOuterJoin(String habitacion);

    public List<Hotel> buscarHotelFetchJoin(String habitacion);

    public List<Hotel> buscarHotelWhereJoin(String habitacion);

    public Hotel buscar(Integer id);

    public List<Hotel> buscarTodos();

    public void eliminar(Integer id);

    public Hotel insertar(Hotel hotel);

    public Hotel actualizar(Hotel hotel);

}
