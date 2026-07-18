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
public class WechatLoginRes {

    @Schema(description = "访问令牌")
    private String accessToken;

    @Schema(description = "刷新令牌")
    private String refreshToken ;

    @Schema(description = "用户信息")
    private UserInfo userInfo;

    @Data
    @Schema(description = "用户信息")
    public static class UserInfo {

        @Schema(description = "用户ID")
        private String id;

        @Schema(description = "登录账号")
        private String username;

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
    }
}
