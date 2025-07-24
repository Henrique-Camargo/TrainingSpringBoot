package dev.rick.Spring.Training.ninjas.dto;
import dev.rick.Spring.Training.missoes.model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private Integer idade;
    private String imgURL;
    private String email;
    private String rank;
    private MissoesModel missoes;

}
