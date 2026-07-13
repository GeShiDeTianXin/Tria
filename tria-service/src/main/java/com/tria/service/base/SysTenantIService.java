package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysTenant;

import java.util.List;


public interface SysTenantIService extends IService<SysTenant>{

    List<SysTenant> getTenantsByUserId(Long userId);
}
