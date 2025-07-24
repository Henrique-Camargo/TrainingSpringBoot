package dev.rick.Spring.Training.ninjas.services;

import dev.rick.Spring.Training.ninjas.dto.NinjaDTO;
import dev.rick.Spring.Training.ninjas.mapper.NinjaMapper;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import dev.rick.Spring.Training.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO save(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    public List<NinjaDTO> FindAll(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO findById(Long id){
        Optional<NinjaModel> findById = ninjaRepository.findById(id);
        return findById.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO update(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaUpdate = ninjaMapper.map(ninjaDTO);
            ninjaUpdate.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaUpdate);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    //DeleteById
    public void delete(@PathVariable Long id){
        ninjaRepository.deleteById(id);
    }

}
