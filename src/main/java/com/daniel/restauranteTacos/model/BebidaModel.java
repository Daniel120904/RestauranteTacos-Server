package com.daniel.restauranteTacos.model;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.enums.TipoBebida;

public class BebidaModel implements ItemPedido{
    private String nome;
    private double preco;
    private TipoBebida tipo;

    public String getDescricao() {
        return "";
    }

    public double getPreco() {
        return 0;
    }
}
