package com.terror_al_ejecutar.ecommerce.repository;

import com.terror_al_ejecutar.ecommerce.models.CarritoProductos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoProductosRepository extends JpaRepository<CarritoProductos, Long> {

    List<CarritoProductos> findByCarrito_Id(Long id);
}
