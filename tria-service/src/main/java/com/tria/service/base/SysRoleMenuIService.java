package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysRoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public interface SysRoleMenuIService extends IService<SysRoleMenu>{


    List<SysRoleMenu> getRoleMenuByRoleIdList(List<Long> roleIdList);
}
