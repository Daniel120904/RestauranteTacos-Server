package com.daniel.restauranteTacos.service;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.PedidoModel;
import com.daniel.restauranteTacos.model.decorator.AcompanhamentoDecorator;
import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.model.enums.TipoAcompanhamento;
import com.daniel.restauranteTacos.model.enums.TipoBebida;
import com.daniel.restauranteTacos.model.enums.TipoTaco;
import com.daniel.restauranteTacos.repository.PedidoRepository;
import com.daniel.restauranteTacos.service.factory.BebidaFactory;
import com.daniel.restauranteTacos.service.factory.TacoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarPorId(String id) {
        return pedidoRepository.findById(id);
    }

    public PedidoModel salvar(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletar(String id) {
        pedidoRepository.deleteById(id);
    }

    public PedidoModel criarPedido(String nomeCliente, List<Taco> tacos, List<BebidaModel> bebidas) {
        PedidoModel pedido = new PedidoModel();
        pedido.setNomeCliente(nomeCliente);

        // Adicionando tacos e bebidas na lista de itens (ItemPedido é a interface comum)
        List<ItemPedido> itens = new ArrayList<>();
        itens.addAll(tacos);
        itens.addAll(bebidas);

        pedido.setItens(itens);

        // Calcula o valor total
        pedido.calcularValorTotal();

        // Salva no banco (se tiver)
        return pedidoRepository.save(pedido);
    }


    // 🔥 Montagem de Taco com acompanhamentos
    public Taco montarTaco(TipoTaco tipoTaco, List<TipoAcompanhamento> acompanhamentos) {
        Taco taco = TacoFactory.criarTacoBase(tipoTaco);
        for (TipoAcompanhamento ac : acompanhamentos) {
            taco = (Taco) TacoFactory.adicionarAcompanhamento(taco, ac);
        }
        return taco;
    }

    // 🔥 Montagem de bebida
    public BebidaModel criarBebida(TipoBebida tipoBebida) {
        return BebidaFactory.criarBebida(tipoBebida);
    }

}
