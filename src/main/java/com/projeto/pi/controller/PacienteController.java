package com.projeto.pi.controller;


import com.projeto.pi.model.Agendamento;
import com.projeto.pi.model.Paciente;
import com.projeto.pi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/find")
    public ResponseEntity<List<Paciente>> find() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Paciente> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pacienteService.findByIdOrThrowException(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Paciente> saveAll(@RequestBody Paciente paciente) {

        return ResponseEntity.ok(pacienteService.save(paciente));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        this.pacienteService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {

        return ResponseEntity.ok(pacienteService.update(paciente));
    }
}
