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

    @PostMapping("/creat")
    public NinjaModel creat(@RequestBody NinjaModel ninja){
        return ninjaService.creat(ninja);
    }

    @GetMapping("/all")
    public List<NinjaModel> findAll(){
       return ninjaService.FindAll();
    }

    @GetMapping("/all/{id}")
    public NinjaModel findById(@PathVariable Long id){
        return ninjaService.findById(id);
    }

    @PutMapping("/alterar")
    public String AlterarNinjaPorID(){
        return "Alterar Ninja por ID";
    }

    @DeleteMapping("/deletarPorID")
    public String DeletarPorID(){
        return "deletar Ninja por id";
    }


}
