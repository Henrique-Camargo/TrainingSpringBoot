package dev.rick.Spring.Training.ninjas.controller;

import dev.rick.Spring.Training.ninjas.dto.NinjaDTO;
import dev.rick.Spring.Training.ninjas.model.NinjaModel;
import dev.rick.Spring.Training.ninjas.services.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> save(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.save(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getName() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/get")
    public ResponseEntity<List<NinjaDTO>> findAll(){
       List<NinjaDTO> ninjas = ninjaService.FindAll();
       return ResponseEntity.ok(ninjas);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.findById(id);
        if (ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao existe nos nossos registros");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdate){
        NinjaDTO ninja = ninjaService.update(id, ninjaUpdate);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao encontrado");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (ninjaService.findById(id) != null){
            ninjaService.delete(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID: " + id + " nao encontrado");
        }

    }



}
