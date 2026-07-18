package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysUserIdentity;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
public interface SysUserIdentityIService extends IService<SysUserIdentity>{
    SysUserIdentity findUserIdentity(String identityType, String identityKey);
}
