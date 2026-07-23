package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.mapper.IngredientNutritionMapper;
import com.tria.entity.IngredientNutrition;
import com.tria.service.base.IngredientNutritionIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class IngredientNutritionServiceImpl extends ServiceImpl<IngredientNutritionMapper, IngredientNutrition> implements IngredientNutritionIService{

}
