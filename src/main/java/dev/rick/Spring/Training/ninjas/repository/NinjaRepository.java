package dev.rick.Spring.Training.ninjas.repository;

import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
