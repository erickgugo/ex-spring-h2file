package com.example.springh2file.controller;

import com.example.springh2file.models.entity.Persona;
import com.example.springh2file.models.services.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/test")
    public String test() {
        log.debug("test");
        log.info("test");
        log.error("test");
        log.warn("test");
        return "Test Run";
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Persona persona) {
        Map<String, Object> response = new HashMap<>();
        Persona personaNew;
        try {
            personaNew = personaService.save(persona);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realiza el insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito!");
        response.put("cliente", personaNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> show() {
        Map<String, Object> response = new HashMap<>();
        List<Persona> listPersona;
        try {
            listPersona = personaService.findAll();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al obtener la informacion de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Listado de cliente corretamente.");
        response.put("personas", listPersona);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
