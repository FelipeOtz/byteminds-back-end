package com.projeto.pi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString

@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String horarioatendimento;
    @Column(nullable = false)
    private String comochegar;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private Long numero;

    //Pode ser null
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cep;


}
