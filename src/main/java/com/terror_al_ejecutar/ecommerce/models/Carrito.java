package com.terror_al_ejecutar.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "usuario_id")
    private User usuario;
    @Column(name = "total")
    private Integer total;
}
