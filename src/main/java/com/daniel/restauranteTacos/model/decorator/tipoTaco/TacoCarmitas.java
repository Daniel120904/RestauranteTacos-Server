package com.daniel.restauranteTacos.model.decorator.tipoTaco;

import com.daniel.restauranteTacos.model.decorator.Taco;

public class TacoCarmitas extends Taco{
    public TacoCarmitas() {
        this.setDescricao("Taco de Carmitas");
        this.setPreco(10.0);
    }
}
