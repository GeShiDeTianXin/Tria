package com.tria.convert;

import com.tria.dto.model.HomeInfo;
import com.tria.dto.res.HomeInfoRes;
import com.tria.dto.res.UserLoginRes;
import com.tria.dto.res.WechatLoginRes;
import com.tria.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Mapper(componentModel = "spring")
public interface AuthConvert {
    @Mapping(source = "sysUser",target = "userInfo")
    UserLoginRes toUserLoginRes(SysUser sysUser,
                                List<SysTenant> tenantsByUserId,
                                List<SysUserRole> userRoleByUserId,
                                List<SysRole> roleInfoByRoleIdList,
                                List<SysMenu> sysMenuList);

    List<HomeInfo>  toHomeInfoRes(List<SysUserTenant> sysUserTenantList);


    @Mapping(source = "sysUser",target = "userInfo")
    WechatLoginRes toWechatLoginRes(SysUser sysUser,String accessToken,String refreshToken);
}