package com.robson.company.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_configuracao_jogo_seq", allocationSize = 1)
@Entity
@Table(name = "tb_configuracao_jogo")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_configuracao_jogo_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "moeda_inicial")
    private Long initialCoins;
    @Column(name = "pontuacao_por_acerto")
    private Long scorePerHit;
    @Column(name = "level")
    private String level;

    public Configuration() {

    }

    public Configuration(Long id, Long initialCoins, Long scorePerHit, String level) {
        this.id = id;
        this.initialCoins = initialCoins;
        this.scorePerHit = scorePerHit;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInitialCoins() {
        return initialCoins;
    }

    public void setInitialCoins(Long initialCoins) {
        this.initialCoins = initialCoins;
    }

    public Long getScorePerHit() {
        return scorePerHit;
    }

    public void setScorePerHit(Long scorePerHit) {
        this.scorePerHit = scorePerHit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "id=" + id +
                ", initialCoins=" + initialCoins +
                ", scorePerHit=" + scorePerHit +
                ", level='" + level + '\'' +
                '}';
    }


    public static final class Builder {
        private Configuration configuration;

        private Builder() {
            configuration = new Configuration();
        }

        public static Builder aConfiguration() {
            return new Builder();
        }

        public Builder id(Long id) {
            configuration.setId(id);
            return this;
        }

        public Builder initialCoins(Long initialCoins) {
            configuration.setInitialCoins(initialCoins);
            return this;
        }

        public Builder scorePerHit(Long scorePerHit) {
            configuration.setScorePerHit(scorePerHit);
            return this;
        }

        public Builder level(String level) {
            configuration.setLevel(level);
            return this;
        }

        public Configuration build() {
            return configuration;
        }
    }
}
