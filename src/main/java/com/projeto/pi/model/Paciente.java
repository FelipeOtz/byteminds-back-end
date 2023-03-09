package com.projeto.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString

@Entity
@Table(name = "paciente")

public class Paciente implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(nullable = false)
    private String imageURL;
	@Column(nullable = false)
    private String nome;
	@Column(nullable = false)
    private String cpf;
	@Column(nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate data_nasc;
	@Column(nullable = false)
    private String sexo;
	@Column(nullable = false)
    private String observacao;
	@Column(nullable = false)
    private String celular;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String celularrecado;
	@Column(nullable = false)
    private Long numero;
	@Column(nullable = false)
    private String rua;
	@Column(nullable = false)
    private String cep;
	@Column(nullable = false)
    private String cidade;
	@Column(nullable = false)
    private String estado;
	@Column(nullable = false)
    private String bairro;

    private String complemento;
	@Column(nullable = false)
    private String senha;

    private String convenio;

	
}
