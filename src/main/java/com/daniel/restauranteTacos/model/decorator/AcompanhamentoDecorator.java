package com.daniel.restauranteTacos.model.decorator;

import com.daniel.restauranteTacos.model.ItemPedido;

public abstract class AcompanhamentoDecorator extends Taco {
    protected ItemPedido taco;

    public AcompanhamentoDecorator(ItemPedido taco) {
        this.taco = taco;
    }

    public abstract String getDescricao();
    public abstract double getPreco();
}
