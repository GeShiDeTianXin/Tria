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
 * 用户-家园关联表
 */
@Data
@TableName(value = "t_sys_user_tenant")
public class SysUserTenant {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 成员用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 租户ID(家园ID)
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 该用户对此家园的自定义称呼
     */
    @TableField(value = "tenant_alias")
    private String tenantAlias;

    /**
     * 租户头像/图标（可存emoji或图片URL）
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 排序值,越小越靠前
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 是否为该用户默认展示的家园 0-否 1-是
     */
    @TableField(value = "is_default")
    private Integer isDefault;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}