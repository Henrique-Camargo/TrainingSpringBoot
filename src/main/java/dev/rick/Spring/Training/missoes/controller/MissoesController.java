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

    //@PostMapping

    @GetMapping("/all")
    public List<MissoesModel> Findall(){
        return missoesService.findAll();
    }

    //@GetMapping("id")

    //@PutMapping

    //@DeleteMapping


}
