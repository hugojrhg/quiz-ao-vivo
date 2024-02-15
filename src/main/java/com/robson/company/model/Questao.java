package com.robson.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pergunta;
    private String resposta;
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Alternativa> alternativas = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema temaDentroDaQuestao;
    public Questao(){

    }

    public Questao(Long id, String pergunta, String resposta, List<Alternativa> alternativas, Tema temaDentroDaQuestao) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativas = alternativas;
        this.temaDentroDaQuestao = temaDentroDaQuestao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public Tema getTemaDentroDaQuestao() {
        return temaDentroDaQuestao;
    }

    public void setTemaDentroDaQuestao(Tema temaDentroDaQuestao) {
        this.temaDentroDaQuestao = temaDentroDaQuestao;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                ", alternativas=" + alternativas +
                ", temaDentroDaQuestao=" + temaDentroDaQuestao +
                '}';
    }

    public static final class Builder {
        private Questao questao;

        private Builder() {
            questao = new Questao();
        }

        public static Builder aQuestao() {
            return new Builder();
        }

        public Builder id(Long id) {
            questao.setId(id);
            return this;
        }

        public Builder pergunta(String pergunta) {
            questao.setPergunta(pergunta);
            return this;
        }

        public Builder resposta(String resposta) {
            questao.setResposta(resposta);
            return this;
        }

        public Builder alternativas(List<Alternativa> alternativas) {
            questao.setAlternativas(alternativas);
            return this;
        }

        public Builder temaDentroDaQuestao(Tema temaDentroDaQuestao) {
            questao.setTemaDentroDaQuestao(temaDentroDaQuestao);
            return this;
        }

        public Questao build() {
            return questao;
        }
    }
}
