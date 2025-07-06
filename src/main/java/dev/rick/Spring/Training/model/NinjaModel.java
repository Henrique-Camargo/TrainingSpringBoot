package dev.rick.Spring.Training.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro_ninja")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer idade;
    private String email;

    public NinjaModel() {}

    public NinjaModel(String name, Integer idade, String email) {
        this.name = name;
        this.idade = idade;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
