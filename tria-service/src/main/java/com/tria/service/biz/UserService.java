package com.tria.service.biz;

import com.tria.dto.req.UserInfoReq;
import com.tria.dto.res.UserInfoRes;

/**
 * @author xc
 * @since 2024-01-05
 */
public interface UserService {
    /**
     * 查询当前用户信息
     * @param userId 用户id
     * @return
     */
    UserInfoRes queryCurrentUserInfo(Long userId);

    /**
     * 更新当前用户信息
     * @param userInfoReq 用户信息
     */
    void updateUserInfo(UserInfoReq userInfoReq);
}
