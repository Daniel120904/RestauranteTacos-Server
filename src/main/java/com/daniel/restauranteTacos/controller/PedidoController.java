package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.dto.PedidoPagamentoRequestDTO;
import com.daniel.restauranteTacos.dto.PedidoRequestDTO;
import com.daniel.restauranteTacos.dto.PedidoResponseDTO;
import com.daniel.restauranteTacos.model.PedidoModel;
import com.daniel.restauranteTacos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoRequestDTO dto) {
        return pedidoService.criarPedido(dto);
    }

    @GetMapping
    public List<PedidoModel> listarPedidos() {return pedidoService.listarPedidos();}

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable String id) {
        PedidoModel pedido = pedidoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PedidoResponseDTO response = pedidoService.converterParaResponse(pedido);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/pagamento")
    public ResponseEntity<PedidoModel> adicionarPagamento(@RequestBody PedidoPagamentoRequestDTO dto) {
        PedidoModel pedido = pedidoService.adicionarPagamento(dto.getPedidoId(), dto.getTipoPagamentoId());
        return ResponseEntity.ok(pedido);
    }


}

