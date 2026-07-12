package com.tria.service.base.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysUserRole;
import com.tria.mapper.SysUserRoleMapper;
import com.tria.service.base.SysUserRoleIService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleIService{

    @Override
    public List<SysUserRole> getUserRoleByUserId(Long id) {
        return this.list(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, id));
    }
}
