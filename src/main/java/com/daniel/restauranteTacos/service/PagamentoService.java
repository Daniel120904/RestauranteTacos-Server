package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.PagamentoModel;
import com.daniel.restauranteTacos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoModel> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<PagamentoModel> buscarPorId(String id) {
        return pagamentoRepository.findById(id);
    }

    public PagamentoModel salvar(PagamentoModel pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void deletar(String id) {
        pagamentoRepository.deleteById(id);
    }
}
