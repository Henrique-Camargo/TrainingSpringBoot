package dev.rick.Spring.Training.ninjas.controller;

import dev.rick.Spring.Training.ninjas.dto.NinjaDTO;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import dev.rick.Spring.Training.ninjas.services.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/save")
    public NinjaDTO save(@RequestBody NinjaDTO ninja){
        return ninjaService.save(ninja);
    }

    @GetMapping("/get")
    public List<NinjaDTO> findAll(){
       return ninjaService.FindAll();
    }

    //
    @GetMapping("/get/{id}")
    public NinjaDTO findById(@PathVariable Long id){
        return ninjaService.findById(id);
    }

    //Update de ninja por ID
    @PutMapping("/update/{id}")
    public NinjaDTO update(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdate){
        return ninjaService.update(id, ninjaUpdate);
    }

    //Deletar por ID(delete)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }



}
