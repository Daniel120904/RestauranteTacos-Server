package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.*;
import com.daniel.restauranteTacos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PagamentoService pagamentoService;

    public PedidoModel criarPedido(String nomeCliente, List<ItemPedido> itens, String idTipoPagamento) {

        PedidoModel pedido = new PedidoModel();
        pedido.setNomeCliente(nomeCliente);
        pedido.setItens(itens);
        pedido.calcularValorTotal();

        PagamentoModel pagamento = pagamentoService.criarPagamento(idTipoPagamento);
        pedido.setPagamento(pagamento);

        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> listarPedidos() {return pedidoRepository.findAll();}

    public Optional<PedidoModel> buscarPorId(String id) {return pedidoRepository.findById(id);}

    public void deletar(String id) {pedidoRepository.deleteById(id);}
}

