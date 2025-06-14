package com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.decorator.AcompanhamentoDecorator;

public class Limao extends AcompanhamentoDecorator {
    public Limao(ItemPedido taco) {
        super(taco);
    }

    @Override
    public String getDescricao() {
        return taco.getDescricao() + ", Limao";
    }

    @Override
    public double getPreco() {
        return taco.getPreco() + 1.00;
    }
}
