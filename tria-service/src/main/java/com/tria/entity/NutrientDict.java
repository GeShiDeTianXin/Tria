package com.tria.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 营养素字典
 */
@Data
@TableName(value = "t_nutrient_dict")
public class NutrientDict {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Object id;

    /**
     * 营养素标识,如 calories/protein/vitamin_c
     */
    @TableField(value = "nutrient_key")
    private String nutrientKey;

    /**
     * 展示名称,如"热量"
     */
    @TableField(value = "`label`")
    private String label;

    /**
     * 单位,如 kcal/g/mg
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;
}