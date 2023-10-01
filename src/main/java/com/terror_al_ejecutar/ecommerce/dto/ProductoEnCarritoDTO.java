package com.terror_al_ejecutar.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEnCarritoDTO {
    private Long productoId;
    private int quantity;
}
