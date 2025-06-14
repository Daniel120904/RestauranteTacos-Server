package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacoService {

    @Autowired
    private TacoRepository tacoRepository;

    public List<Taco> listarTodos() {
        return tacoRepository.findAll();
    }

    public Optional<Taco> buscarPorId(String id) {
        return tacoRepository.findById(id);
    }

    public Taco salvar(Taco taco) {
        return tacoRepository.save(taco);
    }

    public void deletar(String id) {
        tacoRepository.deleteById(id);
    }
}
