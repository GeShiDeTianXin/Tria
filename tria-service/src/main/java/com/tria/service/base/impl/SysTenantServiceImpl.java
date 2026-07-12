package com.tria.service.base.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysTenant;
import com.tria.mapper.SysTenantMapper;
import com.tria.service.base.SysTenantIService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements SysTenantIService{

    @Override
    public List<SysTenant> getTenantsByUserId(Long userId) {
        return list(Wrappers.<SysTenant>lambdaQuery().eq(SysTenant::getUserId, userId));
    }
}
