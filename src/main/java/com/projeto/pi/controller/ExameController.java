package com.projeto.pi.controller;

import com.projeto.pi.model.Exame;
import com.projeto.pi.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exame")

public class ExameController {
    @Autowired
    private ExameService exameService;

    @GetMapping("/find")
    public ResponseEntity<List<Exame>> find() {
        return ResponseEntity.ok(exameService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Exame> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(exameService.findByIdOrThrowException(id));
    }
}
