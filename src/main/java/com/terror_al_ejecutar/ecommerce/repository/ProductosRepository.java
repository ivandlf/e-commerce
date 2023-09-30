package com.terror_al_ejecutar.ecommerce.repository;

import com.terror_al_ejecutar.ecommerce.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
