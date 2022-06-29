package com.example.springh2file.models.dao;

import com.example.springh2file.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long> {
}
