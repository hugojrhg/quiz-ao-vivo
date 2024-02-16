package com.robson.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pergunta;

    private String resposta;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Alternativa> alternativeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tema")
    private Tema tema;

}
