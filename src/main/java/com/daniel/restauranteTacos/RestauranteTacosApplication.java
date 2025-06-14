package com.daniel.restauranteTacos;

import com.daniel.restauranteTacos.model.decorator.Taco;
import com.daniel.restauranteTacos.model.enums.TipoAcompanhamento;
import com.daniel.restauranteTacos.model.enums.TipoTaco;
import com.daniel.restauranteTacos.service.factory.TacoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteTacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteTacosApplication.class, args);

		Taco taco = TacoFactory.criarTacoBase(TipoTaco.AL_PASTOR);
		taco = (Taco) TacoFactory.adicionarAcompanhamento(taco, TipoAcompanhamento.PIMENTA_VERDE);
		taco = (Taco) TacoFactory.adicionarAcompanhamento(taco, TipoAcompanhamento.LIMAO);

		System.out.println(taco.getDescricao());
		System.out.println(taco.getPreco());

	}

}
