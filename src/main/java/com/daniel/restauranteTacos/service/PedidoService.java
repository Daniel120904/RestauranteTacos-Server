package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.dto.PedidoRequestDTO;
import com.daniel.restauranteTacos.dto.PedidoResponseDTO;
import com.daniel.restauranteTacos.model.*;
import com.daniel.restauranteTacos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PedidoService {

    private final TacoRepository tacoRepository;
    private final AcompanhamentoRepository acompanhamentoRepository;
    private final BebidaRepository bebidaRepository;
    private final PedidoRepository pedidoRepository;
    private final PagamentoService pagamentoService;

    public PedidoModel criarPedido(PedidoRequestDTO dto) {
        List<ItemPedido> itens = new ArrayList<>();

        itens.addAll(tacoRepository.findAllById(dto.getTacosIds()));
        itens.addAll(acompanhamentoRepository.findAllById(dto.getAcompanhamentosIds()));
        itens.addAll(bebidaRepository.findAllById(dto.getBebidasIds()));

        if (itens.isEmpty()) {
            throw new RuntimeException("Nenhum item encontrado.");
        }

        PedidoModel pedido = new PedidoModel();
        pedido.setNomeCliente(dto.getNomeCliente());
        pedido.setItens(itens);
        pedido.calcularValorTotal();

        return pedidoRepository.save(pedido);
    }

    public PedidoModel adicionarPagamento(String pedidoId, String tipoPagamentoId) {
        PedidoModel pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PagamentoModel pagamento = pagamentoService.criarPagamento(tipoPagamentoId);

        pedido.setPagamento(pagamento);

        return pedidoRepository.save(pedido);
    }

    public PedidoResponseDTO converterParaResponse(PedidoModel pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setId(pedido.getId());
        dto.setNomeCliente(pedido.getNomeCliente());

        dto.setTacos(
                pedido.getItens().stream()
                        .filter(item -> item instanceof TacoModel)
                        .map(ItemPedido::getDescricao)
                        .toList()
        );

        dto.setAcompanhamentos(
                pedido.getItens().stream()
                        .filter(item -> item instanceof AcompanhamentoModel)
                        .map(ItemPedido::getDescricao)
                        .toList()
        );

        dto.setBebidas(
                pedido.getItens().stream()
                        .filter(item -> item instanceof BebidaModel)
                        .map(ItemPedido::getDescricao)
                        .toList()
        );

        dto.setPrecoTotal(pedido.getValorTotal());

        if (pedido.getPagamento() != null) {
            dto.setTipoPagamento(pedido.getPagamento().getTipoPagamento().getNome());
            dto.setDataPagamento(pedido.getPagamento().getDataPagamento());
        }

        return dto;
    }




    public List<PedidoModel> listarPedidos() {return pedidoRepository.findAll();}

    public Optional<PedidoModel> buscarPorId(String id) {return pedidoRepository.findById(id);}

    public void deletar(String id) {pedidoRepository.deleteById(id);}
}

