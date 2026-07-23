package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.UserIdReq;
import com.tria.dto.req.UserInfoReq;
import com.tria.dto.res.UserInfoRes;
import com.tria.service.biz.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client/user")
public class UserController {

    private final UserService userService;

    /**
     * 微信登录
     */
    @PostMapping("/query")
    public Result<UserInfoRes> queryCurrentUserInfo(@RequestBody UserIdReq req) {
        req.doValidate();
        return Result.success(userService.queryCurrentUserInfo(req.getUserId()));
    }

    /**
     * 用户信息更新
     */
    @PostMapping("/update")
    public Result<Void> updateUserInfo(@RequestBody UserInfoReq req) {
        req.doValidate();
        userService.updateUserInfo(req);
        return Result.success(null);
    }
}
