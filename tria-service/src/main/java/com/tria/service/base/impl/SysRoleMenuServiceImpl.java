package com.tria.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysRoleMenu;
import com.tria.mapper.SysRoleMenuMapper;
import com.tria.service.base.SysRoleMenuIService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuIService{

    @Override
    public List<SysRoleMenu> getRoleMenuByRoleIdList(List<Long> roleIdList) {
        return List.of();
    }
}
