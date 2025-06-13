package com.daniel.restauranteTacos.model.decorator;

import com.daniel.restauranteTacos.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tacos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco implements ItemPedido {
    private String descricao;
    private double preco;

    public String getDescricao() {
        return "";
    }

    public double getPreco() {
        return 0;
    }
}
