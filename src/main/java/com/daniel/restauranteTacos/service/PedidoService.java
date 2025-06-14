package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.*;
import com.daniel.restauranteTacos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(String nomeCliente, List<ItemPedido> itens, PagamentoModel pagamento) {
        PedidoModel pedido = new PedidoModel();
        pedido.setNomeCliente(nomeCliente);
        pedido.setItens(itens);
        pedido.setPagamento(pagamento);

        pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }
}

