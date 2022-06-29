package com.example.springh2file.models.services.impl;

import com.example.springh2file.models.dao.PersonaDao;
import com.example.springh2file.models.entity.Persona;
import com.example.springh2file.models.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Transactional
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }
}
