package com.tria.service.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tria.convert.AuthConvert;
import com.tria.dto.model.HomeInfo;
import com.tria.dto.res.HomeInfoRes;
import com.tria.entity.SysTenant;
import com.tria.entity.SysUserTenant;
import com.tria.service.base.SysTenantIService;
import com.tria.service.base.SysUserTenantIService;
import com.tria.service.biz.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final SysUserTenantIService sysUserTenantIService;
    private final SysTenantIService sysTenantIService;
    private final AuthConvert authConvert;

    @Override
    public HomeInfoRes getHomeInfoByUserId(Long userId) {
        SysTenant sysTenant = sysTenantIService.getOne(Wrappers.<SysTenant>lambdaQuery().eq(SysTenant::getUserId, userId).eq(SysTenant::getIsDefault, 1));
        List<SysUserTenant> list = sysUserTenantIService.list(Wrappers.<SysUserTenant>lambdaQuery().eq(SysUserTenant::getUserId, userId).orderByAsc(SysUserTenant::getSortOrder));
        List<HomeInfo> homeInfoList = authConvert.toHomeInfoRes(list);
        homeInfoList.forEach(item -> {
            if (item.getTenantId().equals(sysTenant.getId())) {
                item.setIsInitDefault(1);
            } else {
                item.setIsInitDefault(0);
            }
        });
        HomeInfoRes homeInfoRes = new HomeInfoRes();
        homeInfoRes.setHomeInfoList(homeInfoList);
        return homeInfoRes;
    }
}
