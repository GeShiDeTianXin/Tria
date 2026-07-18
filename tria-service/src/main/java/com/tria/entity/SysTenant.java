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
 * 租户表
 */
@Data
@TableName(value = "t_sys_tenant")
public class SysTenant {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 租户编码，业务侧唯一标识
     */
    @TableField(value = "tenant_code")
    private String tenantCode;

    /**
     * 租户名称
     */
    @TableField(value = "tenant_name")
    private String tenantName;

    /**
     * 租户头像/图标（可存emoji或图片URL）
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 状态 0-禁用 1-正常
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 是否管理员 0-否 1-是
     */
    @TableField(value = "is_admin")
    private Integer isAdmin;

    /**
     * 是否为初始化默认家园 0-否 1-是
     */
    @TableField(value = "is_default")
    private Integer isDefault;

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