package com.projeto.pi.service;

import com.projeto.pi.model.Agendamento;
import com.projeto.pi.model.Paciente;
import com.projeto.pi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class PacienteService {


    @Autowired
    private PacienteRepository pacienteRepository;
    public Paciente findByIdOrThrowException(Long id){

        return this.pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }

    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    public Paciente save(Paciente paciente) {

        return this.pacienteRepository.save(paciente);

    }

    public void deleteById(Long id) {

        this.findByIdOrThrowException(id);

        this.pacienteRepository.deleteById(id);
    }

    public Paciente update(Paciente paciente) {

        Long id = paciente.getId();

        this.findByIdOrThrowException(id);

        return this.pacienteRepository.save(paciente);
    }

}
