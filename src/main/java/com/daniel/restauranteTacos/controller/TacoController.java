package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.service.TacoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tacos")
public class TacoController {

    private final TacoService tacoService;

    public TacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }

    @GetMapping
    public List<Taco> listarTacos() {
        return tacoService.listarTacos();
    }

    @PostMapping
    public Taco criarTaco(@RequestBody Taco taco) {
        return tacoService.salvarTaco(taco);
    }
}
