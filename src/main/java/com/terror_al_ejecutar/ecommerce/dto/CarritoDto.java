package com.terror_al_ejecutar.ecommerce.dto;

import com.terror_al_ejecutar.ecommerce.models.Productos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDto {
    private Long id;
    private Long userId;
    private String userName;
    private List<ProductoEnCarritoDTO> productosList;
    private Integer total;
}
