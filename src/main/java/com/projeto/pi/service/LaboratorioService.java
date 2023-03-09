package com.projeto.pi.service;

import com.projeto.pi.model.Laboratorio;
import com.projeto.pi.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;
    public Laboratorio findByIdOrThrowException(Long id){

        return this.laboratorioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Laboratorio não encontrada"));
    }

    public List<Laboratorio> findAll() {
        return this.laboratorioRepository.findAll();
    }
}
