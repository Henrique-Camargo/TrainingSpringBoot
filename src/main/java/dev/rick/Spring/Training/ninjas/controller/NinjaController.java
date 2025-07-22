package dev.rick.Spring.Training.ninjas.controller;

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
    public NinjaModel save(@RequestBody NinjaModel ninja){
        return ninjaService.save(ninja);
    }

    @GetMapping("/get")
    public List<NinjaModel> findAll(){
       return ninjaService.FindAll();
    }

    //
    @GetMapping("/get/{id}")
    public NinjaModel findById(@PathVariable Long id){
        return ninjaService.findById(id);
    }

    //Update de ninja por ID
    @PutMapping("/update/{id}")
    public NinjaModel update(@PathVariable Long id, @RequestBody NinjaModel ninjaUpdate){
        return ninjaService.update(id, ninjaUpdate);
    }

    //Deletar por ID(delete)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }



}
