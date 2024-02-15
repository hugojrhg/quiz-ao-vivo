package com.robson.company.model;

import jakarta.persistence.*;

@Entity
@Table
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String alternativa;
    private boolean ehCorreta;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public Alternativa() {

    }

    public Alternativa(Long id, String alternativa, boolean ehCorreta, Questao questao) {
        this.id = id;
        this.alternativa = alternativa;
        this.ehCorreta = ehCorreta;
        this.questao = questao;
    }

    public Alternativa(String alternativa, boolean ehCorreta, Questao questao) {
        this.alternativa = alternativa;
        this.ehCorreta = ehCorreta;
        this.questao = questao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public boolean isEhCorreta() {
        return ehCorreta;
    }

    public void setEhCorreta(boolean ehCorreta) {
        this.ehCorreta = ehCorreta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
