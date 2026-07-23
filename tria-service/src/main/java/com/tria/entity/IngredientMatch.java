package com.tria.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
/**
 * 食材搭配关系
 */
@Data
@TableName(value = "t_ingredient_match")
public class IngredientMatch {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Object id;

    /**
     * 本食材ID,关联 t_ingredient.id
     */
    @TableField(value = "ingredient_id")
    private Object ingredientId;

    /**
     * 关联食材ID,关联 t_ingredient.id
     */
    @TableField(value = "related_ingredient_id")
    private Object relatedIngredientId;

    /**
     * 1=宜搭 2=相克 3=最佳搭配
     */
    @TableField(value = "match_type")
    private Integer matchType;

    /**
     * 搭配说明
     */
    @TableField(value = "match_desc")
    private String matchDesc;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}