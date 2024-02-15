package com.robson.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tema;
    @OneToMany(mappedBy = "temaDentroDaQuestao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Questao> questaoList = new ArrayList<>();

    public Tema() {
    }

    public Tema(Long id, String tema, List<Questao> questaoList) {
        this.id = id;
        this.tema = tema;
        this.questaoList = questaoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", tema='" + tema + '\'' +
                ", questaoList=" + questaoList +
                '}';
    }


    public static final class Builder {
        private Tema temaBuilder;

        private Builder() {
            temaBuilder = new Tema();
        }

        public static Builder aTema() {
            return new Builder();
        }

        public Builder id(Long id) {
            temaBuilder.setId(id);
            return this;
        }

        public Builder tema(String tema) {
            temaBuilder.setTema(tema);
            return this;
        }

        public Builder questaoList(List<Questao> questaoList) {
            temaBuilder.setQuestaoList(questaoList);
            return this;
        }

        public Tema build() {
            return temaBuilder;
        }
    }
}
