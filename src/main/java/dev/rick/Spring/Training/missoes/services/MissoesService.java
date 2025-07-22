package dev.rick.Spring.Training.missoes.services;

import dev.rick.Spring.Training.missoes.model.MissoesModel;
import dev.rick.Spring.Training.missoes.repository.MissioesRepository;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissioesRepository missioesRepository;

    public MissoesService(MissioesRepository missioesRepository) {
        this.missioesRepository = missioesRepository;
    }

    //Put
    public MissoesModel save(MissoesModel missoesModel){
        return missioesRepository.save(missoesModel);
    }

    //GetAll
    public List<MissoesModel> findAll(){
        return missioesRepository.findAll();
    }

    //GetById
    public MissoesModel findById(Long id){
        Optional<MissoesModel> findById = missioesRepository.findById(id);
        return findById.orElse(null);
    }

    //UpdateById
    public MissoesModel update(Long id, MissoesModel missoesUpdate){
        if (missioesRepository.existsById(id)){
            missoesUpdate.setId(id);
            return missioesRepository.save(missoesUpdate);
        }
        return null;
    }

    //DeleteById
    public void delete(@PathVariable Long id){
        missioesRepository.deleteById(id);
    }



}
