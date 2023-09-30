package com.terror_al_ejecutar.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoEnCarritoDTO {
    private Long productoId;
    private int quantity;
}
