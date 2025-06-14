package com.daniel.restauranteTacos.model.decorator.tipoTaco;

import com.daniel.restauranteTacos.model.decorator.Taco;

public class TacoSuadero extends Taco {
    public TacoSuadero() {
        this.setDescricao("Taco de Suadero");
        this.setPreco(15.0);
    }
}
