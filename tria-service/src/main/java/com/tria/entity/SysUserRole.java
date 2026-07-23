package com.tria.entity;

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
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}