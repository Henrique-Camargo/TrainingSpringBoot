package dev.rick.Spring.Training.missoes.repository;

import dev.rick.Spring.Training.missoes.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissioesRepository extends JpaRepository<MissoesModel, Long> {

}
