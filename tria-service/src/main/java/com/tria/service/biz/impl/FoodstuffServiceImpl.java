package com.tria.service.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tria.dto.res.IngredientSimple;
import com.tria.entity.Ingredient;
import com.tria.service.base.IngredientIService;
import com.tria.service.biz.FoodstuffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FoodstuffServiceImpl implements FoodstuffService {

    private final IngredientIService ingredientIService;

    @Override
    public List<IngredientSimple> getAllIngredientSimple(String name) {
        List<Ingredient> list = ingredientIService.list(Wrappers.<Ingredient>lambdaQuery().like(Ingredient::getName, name));
        if (CollUtil.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().map(item -> {
            IngredientSimple ingredientSimple = new IngredientSimple();
            ingredientSimple.setId(item.getId());
            ingredientSimple.setName(item.getName());
            return ingredientSimple;
        }).toList();
    }
}
