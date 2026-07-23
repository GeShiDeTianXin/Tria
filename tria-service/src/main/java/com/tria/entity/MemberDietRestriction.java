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
 * 虚拟成员忌口表（家园私有维护）
 */
@Data
@TableName(value = "t_member_diet_restriction")
public class MemberDietRestriction {
    /**
     * 主键，雪花ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 租户ID，冗余存储便于隔离查询
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 关联t_sys_user_tenant.id，仅用于未认领的虚拟成员
     */
    @TableField(value = "member_id")
    private Long memberId;

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

    /**
     * 开始日期
     */
    @TableField(value = "start_date")
    private Object startDate;

    /**
     * 结束日期
     */
    @TableField(value = "end_date")
    private Object endDate;

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