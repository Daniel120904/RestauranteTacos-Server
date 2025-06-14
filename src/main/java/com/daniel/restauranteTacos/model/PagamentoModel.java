package com.daniel.restauranteTacos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "pagamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {

    @Id
    private String id;

    private String tipo;
    private LocalDateTime data;
    private String status;
}
