package dev.rick.Spring.Training.missoes.model;

import dev.rick.Spring.Training.missoes.enums.Dificuldade;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Dificuldade dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissoesModel() {}

    public MissoesModel(String name, Dificuldade dificuldade) {
        this.name = name;
        this.dificuldade = dificuldade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }
}
