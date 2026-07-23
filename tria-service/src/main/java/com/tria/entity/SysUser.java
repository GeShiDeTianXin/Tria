package com.tria.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */

/**
 * 用户表
 */
@Data
@TableName(value = "t_sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 登录账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * BCrypt加密后密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 头像地址
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private LocalDate birthday;

    /**
     * 性别 0-未知 1-男 2-女
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 用户类型 0-普通用户 1-租户管理员 2-超级管理员(不受租户隔离)
     */
    @TableField(value = "user_type")
    private Integer userType;

    /**
     * 状态 0-禁用 1-正常
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 最后登录IP
     */
    @TableField(value = "login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @TableField(value = "login_date")
    private LocalDateTime loginDate;

    /**
     * 密码最后修改时间，用于强制定期改密
     */
    @TableField(value = "pwd_update_time")
    private LocalDateTime pwdUpdateTime;

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