package com.tria.service.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tria.convert.UserInfoConvert;
import com.tria.dto.req.UserInfoReq;
import com.tria.dto.res.UserInfoRes;
import com.tria.entity.SysUser;
import com.tria.entity.UserDietRestriction;
import com.tria.service.base.SysUserIService;
import com.tria.service.base.UserDietRestrictionIService;
import com.tria.service.biz.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final SysUserIService sysUserIService;
    private final UserDietRestrictionIService userDietRestrictionIService;
    private final UserInfoConvert userInfoConvert;

    @Override
    public UserInfoRes queryCurrentUserInfo(Long userId) {
        SysUser sysUser = sysUserIService.getById(userId);
        List<UserDietRestriction> list = userDietRestrictionIService.list(Wrappers.lambdaQuery(UserDietRestriction.class).eq(UserDietRestriction::getUserId, userId));
        return userInfoConvert.convertUserInfo(sysUser, list);
    }

    /**
     * 更新当前用户信息
     *
     * @param userInfoReq 用户信息
     */
    @Override
    public void updateUserInfo(UserInfoReq userInfoReq) {
        SysUser sysUser = sysUserIService.getById(userInfoReq.getUserId());
        sysUser.setNickname(userInfoReq.getNickname());
        sysUser.setAvatar(userInfoReq.getAvatar());
        sysUser.setBirthday(userInfoReq.getBirthday());
        sysUser.setGender(userInfoReq.getGender());
        sysUserIService.updateById(sysUser);
    }
}
