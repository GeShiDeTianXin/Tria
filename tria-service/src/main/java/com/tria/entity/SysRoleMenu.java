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
 * 角色菜单关联表
 */
@Data
@TableName(value = "t_sys_role_menu")
public class SysRoleMenu {

    private Long roleId;


    private Long menuId;
}