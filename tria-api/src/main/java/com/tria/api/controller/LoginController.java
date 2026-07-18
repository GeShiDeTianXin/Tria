package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.UserLoginReq;
import com.tria.dto.req.UserRegisterReq;
import com.tria.dto.req.WechatLoginReq;
import com.tria.dto.res.UserLoginRes;
import com.tria.dto.res.WechatLoginRes;
import com.tria.service.biz.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client/auth")
public class LoginController {

    private final AuthService authService;

    /**
     * 微信登录
     */
    @PostMapping("/wechat/login")
    public Result<WechatLoginRes> wechatLogin(@RequestBody WechatLoginReq req) {
        req.doValidate();
        return Result.success(authService.wechatLogin(req));
    }
}