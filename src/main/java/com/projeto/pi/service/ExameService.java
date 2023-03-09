package com.projeto.pi.service;

import com.projeto.pi.model.Exame;
import com.projeto.pi.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;
    public Exame findByIdOrThrowException(Long id){

        return this.exameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "exame não encontrado"));
    }

    public List<Exame> findAll() {
        return this.exameRepository.findAll();
    }
}
