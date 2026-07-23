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
 * 字典类型表
 */
@Data
@TableName(value = "t_sys_dict_type")
public class SysDictType {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 字典类型编码，如 gender、restriction_type，供代码里查询使用
     */
    @TableField(value = "dict_type")
    private String dictType;

    /**
     * 字典类型名称，如 性别、忌口类型，用于后台管理展示
     */
    @TableField(value = "dict_name")
    private String dictName;

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