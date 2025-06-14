package com.daniel.restauranteTacos.dto;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.model.decorator.Taco;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {
    private String nomeCliente;
    private List<Taco> tacos;
    private List<BebidaModel> bebidas;
}

