package com.tria.admin.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.UserRegisterReq;
import com.tria.service.biz.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final AuthService authService;

    @PostMapping("/register")
    public Result<Void> userLogin(@RequestBody UserRegisterReq req) {
        req.doValidate();
        authService.userRegister(req);
        return Result.success(null);
    }

}