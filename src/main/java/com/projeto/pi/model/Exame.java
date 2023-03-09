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
@Table(name = "exame")

public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private String recomendacao;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private Long duracao;


}
