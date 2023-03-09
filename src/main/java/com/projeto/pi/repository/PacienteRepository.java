package com.projeto.pi.repository;

import com.projeto.pi.model.Exame;
import com.projeto.pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{

}
