package com.daniel.restauranteTacos.service.factory;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.model.enums.TipoBebida;

public class BebidaFactory {

    public static BebidaModel criarBebida(TipoBebida tipo) {
        return switch (tipo) {
            case AGUA -> new BebidaModel("Água", 3.0, TipoBebida.AGUA);
            case SUCO -> new BebidaModel("Suco Natural", 6.0, TipoBebida.SUCO);
            case REFRIGERANTE -> new BebidaModel("Guarana", 6.0, TipoBebida.REFRIGERANTE);
            case ALCOOLICA -> new BebidaModel("Tequila", 6.0, TipoBebida.ALCOOLICA);
        };
    }
}

