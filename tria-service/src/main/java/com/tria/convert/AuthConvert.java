package com.tria.convert;

import com.tria.dto.req.UserRegisterReq;
import com.tria.dto.res.UserLoginRes;
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
    @Mapping(source = "sysUser.id",target = "userId")
    @Mapping(source = "sysUser.username",target = "username")
    @Mapping(source = "sysUser.password",target = "password")
    @Mapping(source = "sysUser.nickname",target = "nickname")
    @Mapping(source = "sysUser.avatar",target = "avatar")
    @Mapping(source = "sysUser.email",target = "email")
    @Mapping(source = "sysUser.mobile",target = "mobile")
    @Mapping(source = "sysUser.gender",target = "gender")
    @Mapping(source = "sysUser.userType",target = "userType")
    @Mapping(source = "sysUser.status",target = "status")
    UserLoginRes toUserLoginRes(SysUser sysUser,
                                List<SysTenant> tenantsByUserId,
                                List<SysUserRole> userRoleByUserId,
                                List<SysRole> roleInfoByRoleIdList,
                                List<SysMenu> sysMenuList);

    SysUser toSysUser(UserRegisterReq userRegisterReq);
}