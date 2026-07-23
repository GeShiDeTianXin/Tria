package com.tria.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngredientSimple {

    @Schema(description = "食材Id")
    private Long id;

    @Schema(description = "食材名称")
    private String name;
}
