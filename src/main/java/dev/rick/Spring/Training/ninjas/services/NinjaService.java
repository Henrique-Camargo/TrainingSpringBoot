package dev.rick.Spring.Training.ninjas.services;

import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import dev.rick.Spring.Training.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> FindAll(){
        return ninjaRepository.findAll();
    }

/*    public FindById(Long id){
        return ninjaRepository.findById(id);
    }*/

}
