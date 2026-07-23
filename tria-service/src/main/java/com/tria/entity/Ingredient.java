package com.tria.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */

/**
 * 食材百科主表
 */
@Data
@TableName(value = "t_ingredient")
public class Ingredient {
    /**
     * 主键(雪花ID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 食材名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 科属分类
     */
    @TableField(value = "category")
    private String category;

    /**
     * 英文名
     */
    @TableField(value = "english_name")
    private String englishName;

    /**
     * 别称
     */
    @TableField(value = "`alias`")
    private String alias;

    /**
     * 食材分类(单选,如:蔬菜/水果/肉类/海鲜/五谷)
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 食材性质(单选,如:寒/凉/平/温/热)
     */
    @TableField(value = "nature")
    private String nature;

    /**
     * 时令季节(多选数组)
     */
    @TableField(value = "seasons")
    private Object seasons;

    /**
     * 功效作用(多选数组)
     */
    @TableField(value = "effects")
    private Object effects;

    /**
     * 特性标签(多选数组)
     */
    @TableField(value = "special_tags")
    private Object specialTags;

    /**
     * 搜索关键词(数组)
     */
    @TableField(value = "keywords")
    private Object keywords;

    /**
     * 适合人群(多选数组)
     */
    @TableField(value = "suitable_people")
    private Object suitablePeople;

    /**
     * 不适人群(多选数组)
     */
    @TableField(value = "unsuitable_people")
    private Object unsuitablePeople;

    /**
     * 烹饪方式(多选数组)
     */
    @TableField(value = "cook_methods")
    private Object cookMethods;

    /**
     * 食材简介
     */
    @TableField(value = "description")
    private String description;

    /**
     * 食材图片URL
     */
    @TableField(value = "image")
    private String image;

    /**
     * 常温保存说明
     */
    @TableField(value = "storage_room")
    private String storageRoom;

    /**
     * 冷藏保存说明
     */
    @TableField(value = "storage_fridge")
    private String storageFridge;

    /**
     * 存放方式
     */
    @TableField(value = "storage_method")
    private String storageMethod;

    /**
     * 存储小贴士
     */
    @TableField(value = "storage_tips")
    private String storageTips;

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
    private Object deleted;
}