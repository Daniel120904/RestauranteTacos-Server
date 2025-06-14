package com.daniel.restauranteTacos.model;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.enums.TipoBebida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bebidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BebidaModel implements ItemPedido {

    @Id
    private String id;

    private String nome;
    private double preco;
    private TipoBebida tipo;

    // 🔥 Construtor customizado (sem id)
    public BebidaModel(String nome, double preco, TipoBebida tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() {
        return nome + " (" + tipo + ")";
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
