package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.dto.ProductoEnCarritoDTO;
import com.terror_al_ejecutar.ecommerce.models.Carrito;
import com.terror_al_ejecutar.ecommerce.models.Productos;

import java.util.List;

public interface CarritoProductosService {
    void createCarritoProductos(List<ProductoEnCarritoDTO> productosList, Carrito carrito);
}
