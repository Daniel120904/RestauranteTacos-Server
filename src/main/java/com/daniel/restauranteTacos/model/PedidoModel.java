package com.daniel.restauranteTacos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoModel {

    @Id
    private String id;

    private String nomeCliente;
    private List<ItemPedido> itens;
    private double valorTotal;

    private PagamentoModel pagamento; // 🔥 Adicionando o pagamento no pedido

    public void calcularValorTotal() {
        this.valorTotal = itens.stream()
                .mapToDouble(ItemPedido::getPreco)
                .sum();
    }
}

