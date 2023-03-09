package com.projeto.pi.service;


import com.projeto.pi.model.Agendamento;
import com.projeto.pi.model.Paciente;
import com.projeto.pi.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento findByIdOrThrowException(Long id) {

        String exceptionMessage = id == null || id == 0
                ?"Id não informado"
                :"Id: "+id+", não encontrado";

        return this.agendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, exceptionMessage));

    }

    public Agendamento save(Agendamento agendamento) {

        return this.agendamentoRepository.save(agendamento);

    }

    public void deleteById(Long id) {

        this.findByIdOrThrowException(id);

        this.agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> findAll() {
        return this.agendamentoRepository.findAll();
    }

    public Agendamento update(Agendamento agendamento) {

        Long id = agendamento.getId();

        this.findByIdOrThrowException(id);

        return this.agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> findAllByPaciente_Id (Long id) {


        return this.agendamentoRepository.findAllByPaciente_Id(id);

    }
}
