package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.dto.CarritoDto;
import com.terror_al_ejecutar.ecommerce.models.Carrito;
import com.terror_al_ejecutar.ecommerce.models.Productos;
import com.terror_al_ejecutar.ecommerce.models.User;
import com.terror_al_ejecutar.ecommerce.repository.CarritoProductosRepository;
import com.terror_al_ejecutar.ecommerce.repository.CarritoRepository;
import com.terror_al_ejecutar.ecommerce.repository.ProductosRepository;
import com.terror_al_ejecutar.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImp implements CarritoService{
    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CarritoProductosRepository carritoProductosRepository;




    @Override
    public List<CarritoDto> findAll() {
        return carritoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CarritoDto convertEntityToDto(Carrito carrito){
        CarritoDto carritoDto = new CarritoDto();
        carritoDto.setId(carrito.getId());
        carritoDto.setUserId(carrito.getUsuario().getId());
        carritoDto.setUserName(carrito.getUsuario().getNombre());
        return carritoDto;
    }

    @Override
    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public void save(CarritoDto carritoDto) {
        Carrito carrito = new Carrito();
        User usuario = userRepository.findById(carritoDto.getUserId()).get();
        Carrito newCarrito = new Carrito();
        newCarrito.setUsuario(usuario);
        newCarrito.setTotal(600);
        carritoRepository.save(newCarrito);
        CarritoProductosService carritoProductosService = new CarritoProductosServiceImp();
        carritoProductosService.createCarritoProductos(carritoDto.getProductosList(), newCarrito);

    }

    @Override
    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
}
