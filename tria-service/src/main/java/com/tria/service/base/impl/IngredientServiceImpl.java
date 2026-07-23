package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.Ingredient;
import com.tria.mapper.IngredientMapper;
import com.tria.service.base.IngredientIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class IngredientServiceImpl extends ServiceImpl<IngredientMapper, Ingredient> implements IngredientIService{

}
