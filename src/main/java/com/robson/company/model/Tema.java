package com.robson.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tema")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tema;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Questao> questions = new ArrayList<>();

}
