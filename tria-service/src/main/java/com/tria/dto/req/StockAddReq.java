package com.tria.dto.req;

import com.tria.dto.model.IngredientDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StockAddReq {
    private List<IngredientDTO> list;
    private List<Long> tenantIds;
}
