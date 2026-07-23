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
 * 库存与家园的多对多关联表
 */
@Data
@TableName(value = "t_inventory_tenant_rel")
public class InventoryTenantRel {
    /**
     * 主键(雪花ID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 库存ID(关联t_inventory)
     */
    @TableField(value = "inventory_id")
    private Long inventoryId;

    /**
     * 家园/租户ID(关联sys_tenant)
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    private Integer deleted;
}