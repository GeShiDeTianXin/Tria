package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.FoodstuffReq;
import com.tria.dto.res.IngredientSimple;
import com.tria.service.biz.FoodstuffService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/client/foodstuff")
public class FoodstuffController {

    private final FoodstuffService foodstuffService;

    @PostMapping("/getAllIngredientSimple")
    public Result<List<IngredientSimple>> getAllIngredientSimple(@RequestBody FoodstuffReq foodstuffReq) {
        return Result.success(foodstuffService.getAllIngredientSimple(foodstuffReq.getName()));
    }
}
