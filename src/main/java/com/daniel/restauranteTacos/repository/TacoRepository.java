package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.decorator.Taco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TacoRepository extends MongoRepository<Taco, String> {
    List<Taco> findByDescricaoContaining(String desc);
}
