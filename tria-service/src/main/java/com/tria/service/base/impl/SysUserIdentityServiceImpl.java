package com.tria.service.base.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.mapper.SysUserIdentityMapper;
import com.tria.entity.SysUserIdentity;
import com.tria.service.base.SysUserIdentityIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysUserIdentityServiceImpl extends ServiceImpl<SysUserIdentityMapper, SysUserIdentity> implements SysUserIdentityIService{

    @Override
    public SysUserIdentity findUserIdentity(String identityType, String identityKey) {
        return this.getOne(Wrappers.<SysUserIdentity>lambdaQuery()
                .eq(SysUserIdentity::getIdentityType, identityType)
                .eq(SysUserIdentity::getIdentityKey, identityKey)
        );
    }
}
