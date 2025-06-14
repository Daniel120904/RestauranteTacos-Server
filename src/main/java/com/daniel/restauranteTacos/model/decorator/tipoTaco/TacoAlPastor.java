package com.daniel.restauranteTacos.model.decorator.tipoTaco;

import com.daniel.restauranteTacos.model.decorator.Taco;

public class TacoAlPastor extends Taco {
    public TacoAlPastor() {
        this.setDescricao("Taco Al Pastor");
        this.setPreco(10.0);
    }
}
