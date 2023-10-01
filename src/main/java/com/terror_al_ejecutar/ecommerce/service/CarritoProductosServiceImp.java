package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.dto.ProductoEnCarritoDTO;
import com.terror_al_ejecutar.ecommerce.models.Carrito;
import com.terror_al_ejecutar.ecommerce.models.CarritoProductos;
import com.terror_al_ejecutar.ecommerce.models.Productos;
import com.terror_al_ejecutar.ecommerce.repository.CarritoProductosRepository;
import com.terror_al_ejecutar.ecommerce.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;


@Service
public class CarritoProductosServiceImp implements CarritoProductosService{

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CarritoProductosRepository carritoProductosRepository;
    @Override
    public void createCarritoProductos(List<ProductoEnCarritoDTO> productosList, Carrito carrito) {
        CarritoProductos carritoProductos = new CarritoProductos();
        productosList.forEach(productoEnCarritoDTO -> {
            int cantidad = productoEnCarritoDTO.getQuantity();
            carritoProductos.setQuantity(cantidad);
        });
        productosList.stream().map(productos -> productosRepository.findById(productos.getProductoId()).get()).forEach(producto -> {
            carritoProductos.setProductos(producto);
            carritoProductos.setCarrito(carrito);
            carritoProductosRepository.save(carritoProductos);
        });
    }
}
