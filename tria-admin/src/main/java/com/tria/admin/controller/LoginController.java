package com.tria.admin.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.UserLoginReq;
import com.tria.dto.res.UserLoginRes;
import com.tria.service.biz.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final AuthService authService;

    @PostMapping("/login")
    public Result<UserLoginRes> userLogin(@RequestBody UserLoginReq userLoginReq) {
        UserLoginRes userLoginRes = authService.userLogin(userLoginReq);
        return Result.success(userLoginRes);
    }

}