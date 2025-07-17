package dev.rick.Spring.Training.missoes.services;

import dev.rick.Spring.Training.missoes.model.MissoesModel;
import dev.rick.Spring.Training.missoes.repository.MissioesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissioesRepository missioesRepository;

    public MissoesService(MissioesRepository missioesRepository) {
        this.missioesRepository = missioesRepository;
    }

    public List<MissoesModel> findAll(){
        return missioesRepository.findAll();
    }

}
