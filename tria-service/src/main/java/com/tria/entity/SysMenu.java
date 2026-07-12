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
 * 菜单及权限表
 */
@Data
@TableName(value = "t_sys_menu")
public class SysMenu {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父菜单ID，0为根
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 菜单类型 1-目录 2-菜单 3-按钮/接口权限点
     */
    @TableField(value = "menu_type")
    private Integer menuType;

    /**
     * 前端路由path
     */
    @TableField(value = "route_path")
    private String routePath;

    /**
     * 前端组件路径
     */
    @TableField(value = "component")
    private String component;

    /**
     * 权限标识，如 system:user:add
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 前端是否显示 0-隐藏 1-显示
     */
    @TableField(value = "visible")
    private Integer visible;

    /**
     * 状态 0-禁用 1-正常
     */
    @TableField(value = "`status`")
    private Integer status;

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