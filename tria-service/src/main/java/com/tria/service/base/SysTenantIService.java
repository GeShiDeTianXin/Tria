package com.tria.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tria.entity.SysTenant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public interface SysTenantIService extends IService<SysTenant>{

    List<SysTenant> getTenantsByUserId(Long userId);
}
