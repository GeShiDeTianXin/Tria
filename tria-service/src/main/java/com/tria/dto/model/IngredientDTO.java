package com.tria.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IngredientDTO {

    private Long ingredientId;

    private String ingredientName;

    private BigDecimal amount;

    private String unit;

    private LocalDate purchaseDate;

    private LocalDate expireDate;

    private Integer source;
}
