package com.tria.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.custom.common.exception.BusinessException;
import com.tria.entity.SysUser;
import com.tria.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@RequiredArgsConstructor
public class UsernameGenerator {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;
    private static final String PREFIX = "WX_USER_";
    private static final int MAX_RETRY = 10;

    private final SysUserMapper userMapper; // 你自己的 Mapper，按 username 查询

    public String generate() {
        for (int i = 0; i < MAX_RETRY; i++) {
            String username = PREFIX + randomStr(LENGTH);
            Long count = userMapper.selectCount(
                    new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username)
            );
            if (count == 0) {
                return username;
            }
        }
        throw new BusinessException("用户名生成失败，请重试");
    }

    private String randomStr(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }
}