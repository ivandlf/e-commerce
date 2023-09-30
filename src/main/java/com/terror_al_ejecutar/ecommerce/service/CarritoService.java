package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.dto.CarritoDto;
import com.terror_al_ejecutar.ecommerce.models.Carrito;
import com.terror_al_ejecutar.ecommerce.models.User;

import java.util.List;
import java.util.Optional;

public interface CarritoService {
    //GET ALL
    List<CarritoDto> findAll();
    //GET BY ID
    Optional<Carrito> findById(Long id);
    //POST

    void save(CarritoDto carritoDto);

    void deleteById(Long id);
}
