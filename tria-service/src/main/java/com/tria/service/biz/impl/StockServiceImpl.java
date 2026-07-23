package com.tria.service.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tria.dto.model.IngredientDTO;
import com.tria.dto.req.IdReq;
import com.tria.dto.req.StockAddReq;
import com.tria.dto.req.StockUpdateReq;
import com.tria.entity.Ingredient;
import com.tria.entity.Inventory;
import com.tria.entity.InventoryTenantRel;
import com.tria.service.base.IngredientIService;
import com.tria.service.base.InventoryIService;
import com.tria.service.base.InventoryTenantRelIService;
import com.tria.service.biz.StockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xc
 * @since 2024-01-05
 */
@Slf4j
@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final IngredientIService ingredientIService;
    private final InventoryIService inventoryIService;
    private final InventoryTenantRelIService inventoryTenantRelIService;

    /**
     * 新增库存记录
     *
     * @param stockAddReq 库存信息传输对象（包含商品ID、仓库ID、数量、批次号等）
     * @return 新增记录的库存ID
     * @throws IllegalArgumentException        当库存数量为负数或商品/仓库不存在时抛出
     * @throws ConcurrentModificationException 当并发创建同一商品库存时抛出
     */
    @Override
    public void addStock(StockAddReq stockAddReq) {
        List<IngredientDTO> list = stockAddReq.getList();
        if (CollUtil.isEmpty(list)) {
            return;
        }
        Map<Long, Ingredient> ingredientMap = ingredientIService.list().stream().collect(Collectors.toMap(Ingredient::getId, Function.identity(), (k1, k2) -> k1));
        List<Inventory> inventoryList = list.stream().map(item -> {
            Ingredient ingredient = ingredientMap.get(item.getIngredientId());
            Inventory inventory = new Inventory();
            inventory.setIngredientId(item.getIngredientId());
            inventory.setIngredientName(item.getIngredientName());
            inventory.setCategory(ingredient.getType());
            inventory.setIcon(ingredient.getImage());
            inventory.setAmount(item.getAmount());
            inventory.setUnit(item.getUnit());
            inventory.setPurchaseDate(item.getPurchaseDate());
            inventory.setExpireDate(item.getExpireDate());
            inventory.setSource(item.getSource());
            return inventory;
        }).toList();
        inventoryIService.saveBatch(inventoryList);

        List<InventoryTenantRel> inventoryTenantRelList = new ArrayList<>();
        stockAddReq.getTenantIds().forEach(tenantId -> {
            List<InventoryTenantRel> inventoryTenantRels = inventoryList.stream().map(item -> {
                InventoryTenantRel inventoryTenantRel = new InventoryTenantRel();
                inventoryTenantRel.setInventoryId(item.getId());
                inventoryTenantRel.setTenantId(tenantId);
                return inventoryTenantRel;
            }).toList();
            inventoryTenantRelList.addAll(inventoryTenantRels);
        });
        inventoryTenantRelIService.saveBatch(inventoryTenantRelList);
    }

    /**
     * 修改现有库存记录
     *
     * @param stockDTO 库存修改信息传输对象（必须包含库存ID）
     * @return true表示修改成功，false表示未找到对应记录
     * @throws IllegalArgumentException 当修改后的数量为负数或库存ID无效时抛出
     */
    @Override
    public boolean updateStock(StockUpdateReq stockDTO) {
        return false;
    }

    /**
     * 根据库存ID删除库存记录（逻辑删除）
     *
     * @param idReq 库存记录ID
     * @return true表示删除成功，false表示记录不存在或已删除
     * @throws IllegalArgumentException 当stockId为null或≤0时抛出
     */
    @Override
    public boolean deleteStock(IdReq idReq) {
        return false;
    }

    /**
     * 查询库存列表
     *
     * @param idReq
     */
    @Override
    public void queryStock(IdReq idReq) {
        List<Long> inventoryIdList = inventoryTenantRelIService.listObjs(
                Wrappers.<InventoryTenantRel>lambdaQuery()
                        .eq(InventoryTenantRel::getTenantId, idReq.getId())
                        .select(InventoryTenantRel::getInventoryId),
                obj -> (Long) obj
        );
        if (CollUtil.isEmpty(inventoryIdList)) {
            return;
        }


        List<Inventory> inventoryList = inventoryIService.listByIds(inventoryIdList);
        if (CollUtil.isEmpty(inventoryList)) {
            return;
        }

        Map<String, List<Inventory>> collect = inventoryList.stream().collect(Collectors.groupingBy(Inventory::getCategory));
    }
}
