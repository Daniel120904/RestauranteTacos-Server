package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.AcompanhamentoModel;
import com.daniel.restauranteTacos.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    public List<AcompanhamentoModel> listarTodos() {
        return acompanhamentoRepository.findAll();
    }
}

