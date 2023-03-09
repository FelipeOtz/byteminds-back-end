package com.projeto.pi.repository;

import com.projeto.pi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {



    List<Agendamento> findAllByPaciente_Id(Long paciente_id);

}
