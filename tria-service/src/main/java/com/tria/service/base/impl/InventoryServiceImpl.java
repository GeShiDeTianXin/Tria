package com.tria.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.Inventory;
import com.tria.mapper.InventoryMapper;
import com.tria.service.base.InventoryIService;
import org.springframework.stereotype.Service;
/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryIService{

}
