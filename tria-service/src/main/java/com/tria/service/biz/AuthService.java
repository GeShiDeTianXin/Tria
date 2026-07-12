package com.tria.service.biz;

import com.tria.dto.req.UserLoginReq;
import com.tria.dto.res.UserLoginRes;

public interface AuthService {
    UserLoginRes userLogin(UserLoginReq req);
}
