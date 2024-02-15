package com.robson.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tabela_pai")
public class Pai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomepai;

    private Long idadePai;
    @OneToMany(mappedBy = "paiDentroDeFilho", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Filho> filho  = new ArrayList<>();
    public Pai() {

    }
    public Pai(Long id, String nomepai, Long idadePai) {
        this.id = id;
        this.nomepai = nomepai;
        this.idadePai = idadePai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomepai() {
        return nomepai;
    }

    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }

    public Long getIdadePai() {
        return idadePai;
    }

    public void setIdadePai(Long idadePai) {
        this.idadePai = idadePai;
    }
}
