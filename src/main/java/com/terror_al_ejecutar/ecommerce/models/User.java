package com.terror_al_ejecutar.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "direccion")
    private String direccion;



}
