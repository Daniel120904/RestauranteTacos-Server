package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.repository.TacoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoService {

    private final TacoRepository tacoRepo;

    public TacoService(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    public List<Taco> listarTacos() {
        return tacoRepo.findAll();
    }

    public Taco salvarTaco(Taco taco) {
        return tacoRepo.save(taco);
    }
}
