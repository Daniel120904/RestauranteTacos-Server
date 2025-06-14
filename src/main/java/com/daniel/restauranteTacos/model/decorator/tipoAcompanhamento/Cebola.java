package com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.decorator.AcompanhamentoDecorator;

public class Cebola extends AcompanhamentoDecorator {
    public Cebola(ItemPedido taco) {
        super(taco);
    }

    @Override
    public String getDescricao() {
        return taco.getDescricao() + ", Cebola";
    }

    @Override
    public double getPreco() {
        return taco.getPreco() + 1.00;
    }
}
