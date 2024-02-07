package com.robson.company.model;


import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String fullName;

    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }


    public static final class Builder {
        private Usuario usuario;

        private Builder() {
            usuario = new Usuario();
        }

        public static Builder anUsuario() {
            return new Builder();
        }

        public Builder id(Long id) {
            usuario.setId(id);
            return this;
        }

        public Builder name(String name) {
            usuario.setName(name);
            return this;
        }

        public Builder fullName(String fullName) {
            usuario.setFullName(fullName);
            return this;
        }

        public Builder age(Integer age) {
            usuario.setAge(age);
            return this;
        }

        public Usuario build() {
            return usuario;
        }
    }
}
