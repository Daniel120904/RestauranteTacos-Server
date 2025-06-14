package com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento;

import com.daniel.restauranteTacos.model.ItemPedido;
import com.daniel.restauranteTacos.model.decorator.AcompanhamentoDecorator;

public class PimentaVermelha extends AcompanhamentoDecorator {
    public PimentaVermelha(ItemPedido taco) {
        super(taco);
    }

    @Override
    public String getDescricao() {
        return taco.getDescricao() + ", Pimenta Vermelha";
    }

    @Override
    public double getPreco() {
        return taco.getPreco() + 2.00;
    }
}
