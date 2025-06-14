package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<BebidaModel> listarTodas() {
        return bebidaRepository.findAll();
    }
}
