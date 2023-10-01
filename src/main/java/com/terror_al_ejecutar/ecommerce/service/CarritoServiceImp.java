package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.dto.CarritoDto;
import com.terror_al_ejecutar.ecommerce.dto.ProductoEnCarritoDTO;
import com.terror_al_ejecutar.ecommerce.models.Carrito;
import com.terror_al_ejecutar.ecommerce.models.CarritoProductos;
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


    @Autowired
    private CarritoProductosService carritoProductosService;




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
        List<CarritoProductos> carritoProductosList = carritoProductosRepository.findByCarrito_Id(carrito.getId());
        List<ProductoEnCarritoDTO> productoEnCarritoDTOList = new ArrayList<>();
        for (CarritoProductos carritoProductos:
             carritoProductosList) {
            ProductoEnCarritoDTO productoEnCarritoDTO = new ProductoEnCarritoDTO(carritoProductos.getProductos().getId(), carritoProductos.getQuantity());
            productoEnCarritoDTOList.add(productoEnCarritoDTO);

        }
        int total = 0;
        for (ProductoEnCarritoDTO productoList : productoEnCarritoDTOList) {
            Productos productos = productosRepository.findById(productoList.getProductoId()).get();
            total += productos.getPrecio() * productoList.getQuantity();

        }
        carritoDto.setTotal(total);
        carritoDto.setProductosList(productoEnCarritoDTOList);
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
        int total = 0;
        List<ProductoEnCarritoDTO> productoEnCarritoDTOList = carritoDto.getProductosList();
        for (ProductoEnCarritoDTO productoList : productoEnCarritoDTOList) {
            Productos productos = productosRepository.findById(productoList.getProductoId()).get();
            total += productos.getPrecio() * productoList.getQuantity();
        }
        newCarrito.setTotal(total);
        carritoRepository.save(newCarrito);
        carritoProductosService.createCarritoProductos(carritoDto.getProductosList(), newCarrito);

    }

    @Override
    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
}
