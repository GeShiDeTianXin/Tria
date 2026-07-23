package com.tria.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
/**
 * 食材挑选技巧
 */
@Data
@TableName(value = "t_ingredient_pick_tip")
public class IngredientPickTip {
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
     * 技巧内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;
}