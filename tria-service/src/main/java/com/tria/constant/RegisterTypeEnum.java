package com.tria.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegisterTypeEnum {
    MOBILE("手机号注册"),
    EMAIL("邮箱验证码"),
    USERNAME("账号密码注册"),
    OAUTH("第三方注册"),
    ;
    private final String desc;

    public static boolean isValidLoginType(RegisterTypeEnum loginTypeEnum) {
        RegisterTypeEnum registerTypeEnum = RegisterTypeEnum.valueOf(loginTypeEnum.name());
        return null != registerTypeEnum;
    }
}
