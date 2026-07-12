package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public interface SysUserRoleIService extends IService<SysUserRole>{
    List<SysUserRole> getUserRoleByUserId(Long id);
}
