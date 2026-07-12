package com.tria.constant;

import com.custom.common.exception.IExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常状态码枚举
 * @author xc
 * @since 2024-01-05
 */
@Getter
@AllArgsConstructor
public enum AuthExceptionEnum implements IExceptionCode {

    // ========== 通用 1xxx ==========
    SUCCESS(200, "操作成功"),
    SYSTEM_ERROR(500, "系统繁忙，请稍后再试"),
    PARAM_ERROR(400, "字段:{0},请求参数不能为空"),

    // ========== 认证授权 2xxx ==========
    UNAUTHORIZED(2001, "未登录或登录已过期"),
    TOKEN_INVALID(2002, "token无效"),
    TOKEN_EXPIRED(2003, "token已过期"),
    FORBIDDEN(2004, "无权限访问该资源"),

    // ========== 登录相关 3xxx ==========
    LOGIN_FAILED(3001, "用户名或密码错误"),
    ACCOUNT_NOT_FOUND(3002, "账号不存在"),
    ACCOUNT_LOCKED(3003, "账号已被锁定"),
    ACCOUNT_DISABLED(3004, "账号已被禁用"),
    CAPTCHA_ERROR(3005, "图形验证码错误或已过期"),
    SMS_CODE_ERROR(3006, "短信验证码错误或已过期"),
    SMS_SEND_TOO_FREQUENT(3007, "短信发送过于频繁"),
    UNSUPPORTED_LOGIN_TYPE(3008, "不支持的登录方式！"),

    // ========== 租户相关 4xxx ==========
    TENANT_NOT_FOUND(4001, "租户不存在"),
    TENANT_DISABLED(4002, "租户已被禁用"),
    TENANT_EXPIRED(4003, "租户已过期"),
    ;

    private final int code;
    private final String message;
}