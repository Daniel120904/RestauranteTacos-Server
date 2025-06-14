package com.daniel.restauranteTacos.service.factory;

import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento.Cebola;
import com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento.Limao;
import com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento.PimentaVerde;
import com.daniel.restauranteTacos.model.decorator.tipoAcompanhamento.PimentaVermelha;
import com.daniel.restauranteTacos.model.decorator.tipoTaco.TacoAlPastor;
import com.daniel.restauranteTacos.model.decorator.tipoTaco.TacoCarmitas;
import com.daniel.restauranteTacos.model.decorator.tipoTaco.TacoSuadero;
import com.daniel.restauranteTacos.model.enums.TipoAcompanhamento;
import com.daniel.restauranteTacos.model.enums.TipoTaco;

public class TacoFactory {

    public static Taco criarTacoBase(TipoTaco tipo) {
        return switch (tipo) {
            case AL_PASTOR -> new TacoAlPastor();
            case CARMITAS -> new TacoCarmitas();
            case SUADERO -> new TacoSuadero();
        };
    }

    public static Taco adicionarAcompanhamento(Taco taco, TipoAcompanhamento tipo) {
        return switch (tipo) {
            case PIMENTA_VERDE-> new PimentaVerde(taco);
            case PIMENTA_VERMELHA -> new PimentaVermelha(taco);
            case LIMAO -> new Limao(taco);
            case CEBOLA -> new Cebola(taco);
        };
    }
}

