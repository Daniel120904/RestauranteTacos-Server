package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.decorator.Taco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends MongoRepository<Taco, String> {
}
