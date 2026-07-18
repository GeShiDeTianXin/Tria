package com.tria.service.biz;

import com.tria.dto.req.WechatLoginReq;
import com.tria.dto.res.WechatLoginRes;

public interface AuthService {
    WechatLoginRes wechatLogin(WechatLoginReq req);
}
