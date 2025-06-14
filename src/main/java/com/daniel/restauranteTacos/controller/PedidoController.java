package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.dto.PedidoRequestDTO;
import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.model.PedidoModel;
import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.model.enums.TipoAcompanhamento;
import com.daniel.restauranteTacos.model.enums.TipoBebida;
import com.daniel.restauranteTacos.model.enums.TipoTaco;
import com.daniel.restauranteTacos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoRequestDTO request) {
        PedidoModel pedido = pedidoService.criarPedido(
                request.getNomeCliente(),
                request.getTacos(),
                request.getBebidas()
        );
        return ResponseEntity.ok(pedido);
    }



    @PostMapping("/taco")
    public Taco criarTaco(@RequestParam TipoTaco tipo,
                          @RequestBody List<TipoAcompanhamento> acompanhamentos) {
        return pedidoService.montarTaco(tipo, acompanhamentos);
    }

    @PostMapping("/bebida")
    public BebidaModel criarBebida(@RequestParam TipoBebida tipo) {
        return pedidoService.criarBebida(tipo);
    }

}
