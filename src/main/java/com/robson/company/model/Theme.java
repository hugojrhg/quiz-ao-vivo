package com.robson.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@SequenceGenerator(name = "tb_theme_seq", allocationSize = 1)
@Entity
@Table(name = "tb_tema")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_theme_seq")
    private Long id;

    @Column(name = "tema")
    private String theme;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Column(name = "questoes")
    private List<Question> questions = new ArrayList<>();

    public Theme() {
    }

    public Theme(Long id, String theme, List<Question> questions) {
        this.id = id;
        this.theme = theme;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", questions=" + questions +
                '}';
    }


    public static final class Builder {
        private Theme theme;

        private Builder() {
            theme = new Theme();
        }

        public static Builder aTheme() {
            return new Builder();
        }

        public Builder id(Long id) {
            theme.setId(id);
            return this;
        }

        public Builder theme(String theme) {
            this.theme.setTheme(theme);
            return this;
        }

        public Builder questions(List<Question> questions) {
            theme.setQuestions(questions);
            return this;
        }

        public Theme build() {
            return theme;
        }
    }
}
