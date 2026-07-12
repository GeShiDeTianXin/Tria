package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public interface SysRoleIService extends IService<SysRole>{


    List<SysRole> getRoleInfoByRoleIdList(List<Long> roleIdList);
}
