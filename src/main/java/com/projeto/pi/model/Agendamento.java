package com.projeto.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString


@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate dataagendamento;

    @JsonFormat(pattern="HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false)
    private String status;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "exame_id")
    @ToString.Exclude
    private Exame exame;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "laboratorio_id")
    @ToString.Exclude
    private Laboratorio laboratorio;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "paciente_id")
    @ToString.Exclude
    private Paciente paciente;









}
