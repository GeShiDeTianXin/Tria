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
     * 成员用户ID；未认领的虚拟成员为空
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 租户ID(家园ID)
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 成员展示名称（虚拟成员必填；已认领成员可与账号昵称不同步，仅作家园内展示名）
     */
    @TableField(value = "member_name")
    private String memberName;

    /**
     * 与创建者的关系，如配偶/子女/父母
     */
    @TableField(value = "relation")
    private String relation;

    /**
     * 是否已认领 0-虚拟成员 1-已关联真实账号
     */
    @TableField(value = "is_claimed")
    private Integer isClaimed;

    /**
     * 认领邀请码，未认领时生成，认领成功后清空
     */
    @TableField(value = "claim_code")
    private String claimCode;

    /**
     * 创建人用户ID，用于权限校验（谁能编辑虚拟成员信息）
     */
    @TableField(value = "created_by")
    private Long createdBy;

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