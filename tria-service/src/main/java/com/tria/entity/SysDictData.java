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
 * 字典数据表
 */
@Data
@TableName(value = "t_sys_dict_data")
public class SysDictData {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 所属字典类型编码，关联t_sys_dict_type.dict_type
     */
    @TableField(value = "dict_type")
    private String dictType;

    /**
     * 字典标签，前端展示文案，如 男、过敏
     */
    @TableField(value = "dict_label")
    private String dictLabel;

    /**
     * 字典键值，业务存储和判断用，如 1、2
     */
    @TableField(value = "dict_value")
    private String dictValue;

    /**
     * 排序值，越小越靠前
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 是否为该字典的默认选中项 0-否 1-是
     */
    @TableField(value = "is_default")
    private Integer isDefault;

    /**
     * 前端展示的样式标记，如颜色/图标类名（可选）
     */
    @TableField(value = "css_class")
    private String cssClass;

    /**
     * 状态 0-禁用 1-正常
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}