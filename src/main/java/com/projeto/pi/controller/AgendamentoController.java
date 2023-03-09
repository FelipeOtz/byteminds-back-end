package com.projeto.pi.controller;


import com.projeto.pi.model.Agendamento;
import com.projeto.pi.service.AgendamentoService;
import com.projeto.pi.service.ExameService;
import com.projeto.pi.service.LaboratorioService;
import com.projeto.pi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private ExameService exameService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Agendamento> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(agendamentoService.findByIdOrThrowException(id));
    }

    @GetMapping("/find/agenda/{id}")
    public ResponseEntity<List<Agendamento>>findByNome(@PathVariable("id") Long id) {

        return ResponseEntity.ok(agendamentoService.findAllByPaciente_Id(id));

    }

    @PostMapping("/save")
    public ResponseEntity<Agendamento> saveAll(@RequestBody Agendamento agendamento) {

        return ResponseEntity.ok(agendamentoService.save(agendamento));
    }

    @PostMapping("/save/pac={peciente_id}lab={laboratorio_id}ex={exame_id}")
    public ResponseEntity<Agendamento> save(

            @PathVariable(value = "peciente_id") Long paciente_id,
            @PathVariable(value = "laboratorio_id") Long laboratorio_id,
            @PathVariable(value = "exame_id") Long exame_id,
            @RequestBody Agendamento agendamento)
    {

        agendamento.setPaciente(pacienteService.findByIdOrThrowException(paciente_id));

        agendamento.setLaboratorio(laboratorioService.findByIdOrThrowException(laboratorio_id));

        agendamento.setExame(exameService.findByIdOrThrowException(exame_id));


        return ResponseEntity.ok(agendamentoService.save(agendamento));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Agendamento>> findAll() {

        return ResponseEntity.ok(agendamentoService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        this.agendamentoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Agendamento> update(@RequestBody Agendamento agendamento) {

        return ResponseEntity.ok(agendamentoService.update(agendamento));
    }



}
