package com.robson.company.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_configuracao_jogo_seq", allocationSize = 1)
@Entity
@Table(name = "tb_configuracao_jogo")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_configuracao_jogo_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "moeda_inicial")
    private Long moedaInicial;
    @Column(name = "pontuacao_por_acerto")
    private Long pontuacaoPorAcerto;
    @Column(name = "level")
    private String level;

    public Configuracao() {

    }

    public Configuracao(Long id, Long moedaInicial, Long pontuacaoPorAcerto, String level) {
        this.id = id;
        this.moedaInicial = moedaInicial;
        this.pontuacaoPorAcerto = pontuacaoPorAcerto;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoedaInicial() {
        return moedaInicial;
    }

    public void setMoedaInicial(Long moedaInicial) {
        this.moedaInicial = moedaInicial;
    }

    public Long getPontuacaoPorAcerto() {
        return pontuacaoPorAcerto;
    }

    public void setPontuacaoPorAcerto(Long pontuacaoPorAcerto) {
        this.pontuacaoPorAcerto = pontuacaoPorAcerto;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "id=" + id +
                ", moedaInicial=" + moedaInicial +
                ", pontuacaoPorAcerto=" + pontuacaoPorAcerto +
                ", level='" + level + '\'' +
                '}';
    }

    public static final class Builder {
        private Configuracao configuracao;

        private Builder() {
            configuracao = new Configuracao();
        }

        public static Builder aConfiguracao() {
            return new Builder();
        }

        public Builder id(Long id) {
            configuracao.setId(id);
            return this;
        }

        public Builder moedaInicial(Long moedaInicial) {
            configuracao.setMoedaInicial(moedaInicial);
            return this;
        }

        public Builder pontuacaoPorAcerto(Long pontuacaoPorAcerto) {
            configuracao.setPontuacaoPorAcerto(pontuacaoPorAcerto);
            return this;
        }

        public Builder level(String level) {
            configuracao.setLevel(level);
            return this;
        }

        public Configuracao build() {
            return configuracao;
        }

    }

}
