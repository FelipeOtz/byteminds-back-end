package com.projeto.pi.controller;

import com.projeto.pi.model.Laboratorio;
import com.projeto.pi.service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping("/find")
    public ResponseEntity<List<Laboratorio>> find() {
        return ResponseEntity.ok(laboratorioService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Laboratorio> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(laboratorioService.findByIdOrThrowException(id));
    }
}
