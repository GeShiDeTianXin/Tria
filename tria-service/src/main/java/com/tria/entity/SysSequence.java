package com.tria.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 通用序号生成表
 */
@Getter
@Setter
@TableName(value = "t_sys_sequence")
public class SysSequence {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 业务类型，如 tenant_code
     */
    @TableField(value = "biz_type")
    private String bizType;

    /**
     * 业务维度组合键（多个维度拼接后的值）
     */
    @TableField(value = "biz_key")
    private String bizKey;

    /**
     * 原始维度字段，便于排查问题，非必须
     */
    @TableField(value = "dimensions")
    private String dimensions;

    /**
     * 乐观锁版本号
     */
    @TableField(value = "version")
    private Integer version;

    @TableField(value = "current_val")
    private Long currentVal;

    @TableField(value = "step")
    private Integer step;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 序号补零位数，0表示不补零
     */
    @TableField(value = "pad_length")
    private Integer padLength;

    /**
     * 序号上限，NULL或0表示不限制
     */
    @TableField(value = "max_val")
    private Long maxVal;
}