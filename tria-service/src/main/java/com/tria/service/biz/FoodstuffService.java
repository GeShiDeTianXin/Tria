package com.tria.service.biz;

import com.tria.dto.res.IngredientSimple;

import java.util.List;

/**
 * 食材接口
 *
 * @author xc
 * @since 2024-01-05
 */
public interface FoodstuffService {
    List<IngredientSimple> getAllIngredientSimple(String name);
}
