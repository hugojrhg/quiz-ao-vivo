package com.robson.company.model;

import jakarta.persistence.*;

@Entity
@Table
public class Filho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeFilho;

    private Long idadeFilho;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questao_id")
    private Pai paiDentroDeFilho;
    public Filho() {

    }
    public Filho(Long id, String nomeFilho, Long idadeFilho) {
        this.id = id;
        this.nomeFilho = nomeFilho;
        this.idadeFilho = idadeFilho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFilho() {
        return nomeFilho;
    }

    public void setNomeFilho(String nomeFilho) {
        this.nomeFilho = nomeFilho;
    }

    public Long getIdadeFilho() {
        return idadeFilho;
    }

    public void setIdadeFilho(Long idadeFilho) {
        this.idadeFilho = idadeFilho;
    }
}
