package com.tria.service.base.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysUserTenant;
import com.tria.mapper.SysUserTenantMapper;
import com.tria.service.base.SysUserTenantIService;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class SysUserTenantServiceImpl extends ServiceImpl<SysUserTenantMapper, SysUserTenant> implements SysUserTenantIService{

}
