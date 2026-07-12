package com.tria.util;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author xc
 * @since 2024-01-05
 */
public class PasswordUtil {

    // 用户注册时：加密密码并存入数据库
    public static String registerUser(String plainPassword) {
        // 加密：每次生成的密文都不同（因为内部自动生成随机盐）
        return DigestUtil.bcrypt(plainPassword);
    }

    // 用户登录时：校验密码
    public static boolean loginUser(String plainPassword, String storedHash) {
        // 验证：storedHash 是从数据库查出来的密文
        return DigestUtil.bcryptCheck(plainPassword, storedHash);
    }

}
