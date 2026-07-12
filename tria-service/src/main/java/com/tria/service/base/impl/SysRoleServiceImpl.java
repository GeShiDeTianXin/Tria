package com.tria.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysRole;
import com.tria.mapper.SysRoleMapper;
import com.tria.service.base.SysRoleIService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleIService{

    @Override
    public List<SysRole> getRoleInfoByRoleIdList(List<Long> roleIdList) {
        return List.of();
    }
}
