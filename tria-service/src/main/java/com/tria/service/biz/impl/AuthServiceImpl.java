package com.tria.service.biz.impl;

import cn.hutool.core.util.ObjUtil;
import com.common.redis.support.RedisUtils;
import com.common.security.context.LoginUser;
import com.common.security.jwt.JwtUtil;
import com.custom.common.exception.BusinessException;
import com.tria.constant.AuthExceptionEnum;
import com.tria.constant.LoginTypeEnum;
import com.tria.convert.UserLoginConvert;
import com.tria.dto.req.UserLoginReq;
import com.tria.dto.res.UserLoginRes;
import com.tria.entity.*;
import com.tria.service.base.*;
import com.tria.service.biz.AuthService;
import com.tria.util.PasswordUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xc
 * @since 2024-01-05
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SysUserIService sysUserIService;
    private final SysLoginLogIService sysLoginLogIService;
    private final SysMenuIService sysMenuIService;
    private final SysOperationLogIService sysOperationLogIService;
    private final SysRoleIService sysRoleIService;
    private final SysRoleMenuIService sysRoleMenuIService;
    private final SysTenantIService sysTenantIService;
    private final SysUserRoleIService sysUserRoleIService;

    private final JwtUtil jwtUtil;
    private final RedisUtils redisUtils;

    private final UserLoginConvert userLoginConvert;

    @Override
    public UserLoginRes userLogin(UserLoginReq req) {
        LoginTypeEnum loginType = req.getLoginType();

        SysUser sysUser = getUserLoginRes(req, loginType);
        if (sysUser.getStatus() == 0) {
            // 账号已经被禁用
            throw new BusinessException(AuthExceptionEnum.ACCOUNT_DISABLED);
        }
        // 用户下的租户
        List<SysTenant> tenantsByUserId = sysTenantIService.getTenantsByUserId(sysUser.getId());
        // 用户下的角色
        List<SysUserRole> userRoleByUserId = sysUserRoleIService.getUserRoleByUserId(sysUser.getId());
        // 用户下的角色Id列表
        List<Long> roleIdList = userRoleByUserId.stream().map(SysUserRole::getRoleId).toList();
        // 用户角色信息
        List<SysRole> roleInfoByRoleIdList = sysRoleIService.getRoleInfoByRoleIdList(roleIdList);
        // 角色菜单信息
        List<SysRoleMenu> roleMenuByRoleIdList = sysRoleMenuIService.getRoleMenuByRoleIdList(roleIdList);
        List<Long> menuIdList = roleMenuByRoleIdList.stream().map(SysRoleMenu::getMenuId).toList();
        List<SysMenu> sysMenuList = new ArrayList<>();

        String token = generateAndStoreToken(sysUser, roleIdList);

        UserLoginRes userLoginRes = userLoginConvert.toUserLoginRes(sysUser, tenantsByUserId, userRoleByUserId, roleInfoByRoleIdList, sysMenuList);
        userLoginRes.setToken(token);
        return null;
    }

    private String generateAndStoreToken(SysUser sysUser, List<Long> roleIdList) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(sysUser.getId());
        loginUser.setUsername(sysUser.getUsername());
        List<String> roleIdStrList = roleIdList.stream().map(String::valueOf).toList();
        loginUser.setRoles(roleIdStrList);
        String token = jwtUtil.generateToken(loginUser);
        redisUtils.set("login:user:" + sysUser.getId(), token, 7, TimeUnit.DAYS);
        return token;
    }

    private SysUser getUserLoginRes(UserLoginReq req, LoginTypeEnum loginType) {
        switch (loginType) {
            case PASSWORD:
                return passwordLogin(req);
            case SMS:
                return smsLogin(req);
            case EMAIL:
                return emailLogin(req);
            case OAUTH:
                return oauthLogin(req);
            default:
                throw new BusinessException(AuthExceptionEnum.UNSUPPORTED_LOGIN_TYPE);
        }
    }

    private SysUser oauthLogin(UserLoginReq req) {
        SysUser sysUser = sysUserIService.findByUsername(req.getUsername());
        if (ObjUtil.isEmpty(sysUser)) {
            throw new BusinessException(AuthExceptionEnum.ACCOUNT_NOT_FOUND);
        }
        if (PasswordUtil.loginUser(req.getPassword(), sysUser.getPassword())) {
            throw new BusinessException(AuthExceptionEnum.LOGIN_FAILED);
        }
        return sysUser;
    }

    private SysUser emailLogin(UserLoginReq req) {
        return null;
    }

    private SysUser smsLogin(UserLoginReq req) {
        return null;
    }

    private SysUser passwordLogin(UserLoginReq req) {
        return null;
    }

    public SysUserIService getUserIService() {
        return sysUserIService;
    }
}
