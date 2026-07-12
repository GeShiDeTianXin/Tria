package com.tria.service.base.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysUser;
import com.tria.mapper.SysUserMapper;
import com.tria.service.base.SysUserIService;
import org.springframework.stereotype.Service;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserIService{
    @Override
    public SysUser findByUsername(String username) {
        return getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUsername, username));
    }
}
