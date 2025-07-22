package dev.rick.Spring.Training.missoes.controller;

import dev.rick.Spring.Training.missoes.model.MissoesModel;
import dev.rick.Spring.Training.missoes.services.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/save")
    public MissoesModel save(MissoesModel missoesModel){
        return missoesService.save(missoesModel);
    }

    @GetMapping("/all")
    public List<MissoesModel> Findall(){
        return missoesService.findAll();
    }

    @GetMapping("/{id}")
    public MissoesModel findById(@PathVariable Long id){
        return missoesService.findById(id);
    }

    @PutMapping("/update/{id}")
    public MissoesModel update(@PathVariable Long id, @RequestBody MissoesModel missoesUpdate){
        return missoesService.update(id, missoesUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        missoesService.delete(id);
    }

}
