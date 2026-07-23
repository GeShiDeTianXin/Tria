package com.tria.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
/**
 * 食材营养成分值
 */
@Data
@TableName(value = "t_ingredient_nutrition")
public class IngredientNutrition {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Object id;

    /**
     * 食材ID,关联 t_ingredient.id
     */
    @TableField(value = "ingredient_id")
    private Object ingredientId;

    /**
     * 关联 t_nutrient_dict.nutrient_key
     */
    @TableField(value = "nutrient_key")
    private String nutrientKey;

    /**
     * 数值
     */
    @TableField(value = "`value`")
    private BigDecimal value;
}