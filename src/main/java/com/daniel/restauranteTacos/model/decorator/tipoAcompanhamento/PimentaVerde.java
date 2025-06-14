package com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.decorator.AcompanhamentoDecorator;

public class PimentaVerde extends AcompanhamentoDecorator {
    public PimentaVerde(ItemPedido taco) {
        super(taco);
    }

    @Override
    public String getDescricao() {
        return taco.getDescricao() + ", Pimenta Verde";
    }

    @Override
    public double getPreco() {
        return taco.getPreco() + 2.00;
    }
}
