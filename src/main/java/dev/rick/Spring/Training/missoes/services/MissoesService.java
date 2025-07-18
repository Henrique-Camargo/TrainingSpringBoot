package dev.rick.Spring.Training.missoes.services;

import dev.rick.Spring.Training.missoes.model.MissoesModel;
import dev.rick.Spring.Training.missoes.repository.MissioesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissioesRepository missioesRepository;

    public MissoesService(MissioesRepository missioesRepository) {
        this.missioesRepository = missioesRepository;
    }

    public List<MissoesModel> findAll(){
        return missioesRepository.findAll();
    }

    public MissoesModel findById(Long id){
        Optional<MissoesModel> findById = missioesRepository.findById(id);
        return findById.orElse(null);
    }

}
