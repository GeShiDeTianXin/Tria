package com.tria.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Getter
@Setter
public class UserLoginRes {

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "登录账号")
    private String username;

    @Schema(description = "BCrypt加密后密码")
    private String password;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别 0-未知 1-男 2-女")
    private Integer gender;

    @Schema(description = "用户类型 0-普通用户 1-租户管理员 2-超级管理员(不受租户隔离)")
    private Integer userType;

    @Schema(description = "状态 0-禁用 1-正常")
    private Integer status;

    @Schema(description = "token")
    private String token;

    @Schema(description = "租户信息列表")
    private List<TenantInfo> tenantInfoList;

    @Schema(description = "角色信息列表")
    private List<RoleInfo> roleInfoList;

    @Schema(description = "角色菜单信息列表")
    private List<RoleMenuInfo> roleMenuInfoList;

    @Data
    @Schema(description = "租户信息")
    public static class TenantInfo {
        @Schema(description = "租户编码，业务侧唯一标识")
        private String tenantCode;
        @Schema(description = "租户名称")
        private String tenantName;
        @Schema(description = "状态 0-禁用 1-正常")
        private Integer status;
    }

    @Data
    @Schema(description = "角色信息")
    public static class RoleInfo {
    }

    @Data
    @Schema(description = "角色菜单信息")
    public static class RoleMenuInfo {
    }
}