package com.tria.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */

/**
 * 库存批次表(每行一个批次,不直接挂家园)
 */
@Data
@TableName(value = "t_inventory")
public class Inventory {
    /**
     * 主键(雪花ID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 食材ID(关联t_ingredient,未匹配到食材库时为空)
     */
    @TableField(value = "ingredient_id")
    private Long ingredientId;

    /**
     * 食材名称(冗余存储,未匹配食材库时以此为准)
     */
    @TableField(value = "ingredient_name")
    private String ingredientName;

    /**
     * 食材分类(冗余自t_ingredient.type,用于列表分组展示)
     */
    @TableField(value = "category")
    private String category;

    /**
     * 食材图标(冗余自t_ingredient.image)
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 单位(如g/kg/个/瓶)
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 购买日期
     */
    @TableField(value = "purchase_date")
    private LocalDate purchaseDate;

    /**
     * 过期日期
     */
    @TableField(value = "expire_date")
    private LocalDate expireDate;

    /**
     * 录入方式(1=手动录入,2=CSV/Excel导入)
     */
    @TableField(value = "`source`")
    private Integer source;

    /**
     * 录入人(关联sys_user)
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    private Integer deleted;
}