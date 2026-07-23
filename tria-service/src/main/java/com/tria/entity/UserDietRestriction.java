package com.tria.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
/**
 * 用户个人忌口表（全局维护，跨家园通用）
 */
@Data
@TableName(value = "t_user_diet_restriction")
public class UserDietRestriction {
    /**
     * 主键，雪花ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 关联t_sys_user.id，本人全局维护，不区分家园
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 食材ID，关联食材库
     */
    @TableField(value = "ingredient_id")
    private Long ingredientId;

    /**
     * 食材名称（冗余快照）
     */
    @TableField(value = "ingredient_name")
    private String ingredientName;

    /**
     * 忌口类型 1-过敏 2-不喜欢 3-饮食限制
     */
    @TableField(value = "restriction_type")
    private Integer restrictionType;

    /**
     * 是否长期忌口 0-否 1-是
     */
    @TableField(value = "is_long_term")
    private Integer isLongTerm;

    @TableField(value = "start_date")
    private LocalDate startDate;

    @TableField(value = "end_date")
    private LocalDate endDate;

    /**
     * 状态 0-已失效 1-生效中
     */
    @TableField(value = "`status`")
    private Integer status;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}