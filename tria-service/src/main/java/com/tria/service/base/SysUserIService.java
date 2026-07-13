package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.dto.req.UserRegisterReq;
import com.tria.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public interface SysUserIService extends IService<SysUser>{
    SysUser findByUsername(String username);
}
