package com.example.springh2file.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "personas")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotEmpty
    //@Size(min = 4, max = 64)
    @Column(nullable = false)
    private String nombres;

    //@NotEmpty
    private String apPaterno;

    private String apMaterno;

    private String docIdentidad;
}
