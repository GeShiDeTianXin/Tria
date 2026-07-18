package com.tria.service.biz.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.common.redis.support.RedisUtils;
import com.common.security.context.LoginUser;
import com.common.security.jwt.JwtUtil;
import com.tria.convert.AuthConvert;
import com.tria.dto.model.WxSessionResult;
import com.tria.dto.req.WechatLoginReq;
import com.tria.dto.res.WechatLoginRes;
import com.tria.entity.SysTenant;
import com.tria.entity.SysUser;
import com.tria.entity.SysUserIdentity;
import com.tria.entity.SysUserTenant;
import com.tria.service.base.*;
import com.tria.service.biz.AuthService;
import com.tria.util.UsernameGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SysUserIService sysUserIService;
    private final SysTenantIService sysTenantIService;
    private final SysSequenceIService sysSequenceIService;
    private final SysUserIdentityIService sysUserIdentityIService;
    private final UsernameGenerator usernameGenerator;
    private final SysUserTenantIService sysUserTenantIService;

    private final JwtUtil jwtUtil;
    private final RedisUtils redisUtils;

    private final AuthConvert authConvert;

    private static final String JSCODE2SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    private static final String appid = "wxffa3784252f4eacc";
    private static final String secret = "b547b44aad670ace41c095ce1ac22095";


    @Override
    public WechatLoginRes wechatLogin(WechatLoginReq req) {
        SysUser sysUser = null;
        WxSessionResult wxSessionResult = code2Session(req.getIdentityKey());
        SysUserIdentity identity = sysUserIdentityIService.findUserIdentity("WECHAT",wxSessionResult.getOpenid());
        if (ObjUtil.isNull(identity)) {
            sysUser = initSysUser();

            // 给用户初始化个租户
            SysTenant sysTenant = this.initSysTenant(sysUser);

            // 用户第三方身份绑定表
            initSysUserIdentity(sysUser, wxSessionResult);

            // 初始化用户家园
            initSysUserTenant(sysUser, sysTenant);
        } else {
            sysUser = sysUserIService.findSysUserById(identity.getUserId());
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(sysUser.getId());
        loginUser.setUsername(sysUser.getUsername());
        List<String> roleIdStrList = new ArrayList<>();
        loginUser.setRoles(roleIdStrList);
        String accessToken = jwtUtil.generateToken(loginUser);
        String refreshToken = jwtUtil.generateRefreshToken(loginUser);

        return authConvert.toWechatLoginRes(sysUser, accessToken, refreshToken);
    }

    private void initSysUserTenant(SysUser sysUser, SysTenant sysTenant) {
        SysUserTenant sysUserTenant = new SysUserTenant();
        sysUserTenant.setUserId(sysUser.getId());
        sysUserTenant.setTenantId(sysTenant.getId());
        sysUserTenant.setTenantAlias(sysTenant.getTenantName());
        String avatar = "\uD83D\uDC64"; // 👤 对应的 UTF-16 surrogate pair
        sysUserTenant.setAvatar(avatar);
        sysUserTenant.setSortOrder(0);
        sysUserTenant.setIsDefault(1);
        sysUserTenantIService.save(sysUserTenant);
    }

    private void initSysUserIdentity(SysUser sysUser, WxSessionResult wxSessionResult) {
        SysUserIdentity sysUserIdentity = new SysUserIdentity();
        sysUserIdentity.setUserId(sysUser.getId());
        sysUserIdentity.setIdentityType("WECHAT");
        sysUserIdentity.setIdentityKey(wxSessionResult.getOpenid());
        sysUserIdentityIService.save(sysUserIdentity);
    }

    private SysUser initSysUser() {
        SysUser sysUser;
        sysUser = new SysUser();
        String username = usernameGenerator.generate();
        sysUser.setUsername(username);
        sysUser.setNickname("微信用户");
        sysUser.setGender(0);
        sysUser.setUserType(0);
        sysUser.setStatus(1);
        sysUserIService.save(sysUser);
        return sysUser;
    }

    private WxSessionResult code2Session(String code) {
        String url = String.format(JSCODE2SESSION_URL, appid, secret, code);
        String response = HttpUtil.get(url); // hutool的HttpUtil，你项目里应该已经引了

        WxSessionResult result = JSONUtil.toBean(response, WxSessionResult.class);

        // 微信这个接口失败时也是200,但body里有errcode字段
        if (result.getErrcode() != null && result.getErrcode() != 0) {
            // throw new BusinessException(AuthExceptionEnum.WECHAT_LOGIN_FAILED, result.getErrmsg());
        }
        return result;
    }

    private SysTenant initSysTenant(SysUser sysUser) {
        String tenant_code = sysSequenceIService.getSequence("T", sysUser.getUsername(), 2, 10L);
        SysTenant sysTenant = new SysTenant();
        sysTenant.setUserId(sysUser.getId());
        sysTenant.setTenantCode(tenant_code);
        sysTenant.setTenantName(sysUser.getNickname()+"的家");
        String avatar = "\uD83D\uDC64"; // 👤 对应的 UTF-16 surrogate pair
        sysTenant.setAvatar(avatar);
        sysTenant.setStatus(1);
        sysTenant.setIsAdmin(1);
        boolean save = sysTenantIService.save(sysTenant);
        return sysTenant;
    }
}
