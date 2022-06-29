package com.example.springh2file.models.services;

import com.example.springh2file.models.entity.Persona;

import java.util.List;

public interface PersonaService {

    Persona save(Persona persona);

    List<Persona> findAll();
}
