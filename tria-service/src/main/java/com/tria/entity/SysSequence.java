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
 * 通用序号生成表
 */
@Data
@TableName(value = "t_sys_sequence")
public class SysSequence {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Object id;

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
    private Object dimensions;

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