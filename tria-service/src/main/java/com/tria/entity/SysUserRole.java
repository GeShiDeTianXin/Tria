package com.tria.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */

/**
 * 用户角色关联表
 */
@Data
@TableName(value = "t_sys_user_role")
public class SysUserRole {

    private Long userId;

    private Long roleId;
}