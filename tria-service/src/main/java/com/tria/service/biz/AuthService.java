package com.tria.service.biz;

import com.tria.dto.req.UserLoginReq;
import com.tria.dto.req.UserRegisterReq;
import com.tria.dto.res.UserLoginRes;
import com.tria.dto.res.UserRegisterRes;

public interface AuthService {
    void userRegister(UserRegisterReq req);
    UserLoginRes userLogin(UserLoginReq req);
}
