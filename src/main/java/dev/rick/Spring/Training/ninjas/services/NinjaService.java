package dev.rick.Spring.Training.ninjas.services;

import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import dev.rick.Spring.Training.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Put
    public NinjaModel save(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //GetAll
    public List<NinjaModel> FindAll(){
        return ninjaRepository.findAll();
    }

    //GetById
    public NinjaModel findById(Long id){
        Optional<NinjaModel> findById = ninjaRepository.findById(id);
        return findById.orElse(null);
    }

    //UpdateById
    public NinjaModel update(Long id, NinjaModel ninjaUpdate){
        if (ninjaRepository.existsById(id)){
            ninjaUpdate.setId(id);
            return ninjaRepository.save(ninjaUpdate);
        }
        return null;
    }

    //DeleteById
    public void delete(@PathVariable Long id){
        ninjaRepository.deleteById(id);
    }

}
