package dev.rick.Spring.Training.missoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.rick.Spring.Training.missoes.enums.Dificuldade;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Dificuldade dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;


}
