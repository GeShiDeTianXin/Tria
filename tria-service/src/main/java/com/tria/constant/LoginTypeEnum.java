package com.tria.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginTypeEnum {
    PASSWORD("账号密码"),
    SMS("短信验证码"),
    EMAIL("邮箱验证码"),
    OAUTH("第三方")
    ;
    private final String desc;

    public static boolean isValidLoginType(LoginTypeEnum loginTypeEnum) {
        LoginTypeEnum loginTypeEnum1 = LoginTypeEnum.valueOf(loginTypeEnum.name());
        return null != loginTypeEnum1;
    }
}
