package com.robson.company.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_alternativa_seq", allocationSize = 1)
@Entity
@Table(name = "tb_alternativa")
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_alternativa_seq")
    private Long id;

    @Column(name = "alternativa")
    private String alternative;

    @Column(name = "correta")
    private boolean itsCorrect;

    @Column(name = "letra_referencia")
    private String referenceLetter;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questao_id")
    private Question question;

    public Alternative() {
    }

    public Alternative(Long id, String alternative, boolean itsCorrect, String referenceLetter, Question question) {
        this.id = id;
        this.alternative = alternative;
        this.itsCorrect = itsCorrect;
        this.referenceLetter = referenceLetter;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public boolean isItsCorrect() {
        return itsCorrect;
    }

    public void setItsCorrect(boolean itsCorrect) {
        this.itsCorrect = itsCorrect;
    }

    public String getReferenceLetter() {
        return referenceLetter;
    }

    public void setReferenceLetter(String referenceLetter) {
        this.referenceLetter = referenceLetter;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                ", itsCorrect=" + itsCorrect +
                ", referenceLetter='" + referenceLetter + '\'' +
                ", question=" + question +
                '}';
    }


    public static final class Builder {
        private Alternative alternative;

        private Builder() {
            alternative = new Alternative();
        }

        public static Builder anAlternative() {
            return new Builder();
        }

        public Builder id(Long id) {
            alternative.setId(id);
            return this;
        }

        public Builder alternative(String alternative) {
            this.alternative.setAlternative(alternative);
            return this;
        }

        public Builder itsCorrect(boolean itsCorrect) {
            alternative.setItsCorrect(itsCorrect);
            return this;
        }

        public Builder referenceLetter(String referenceLetter) {
            alternative.setReferenceLetter(referenceLetter);
            return this;
        }

        public Builder question(Question question) {
            alternative.setQuestion(question);
            return this;
        }

        public Alternative build() {
            return alternative;
        }
    }
}
