package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.model.DietaryRestrictionDTO;
import com.tria.dto.req.IdReq;
import com.tria.dto.req.SaveDietaryRestrictionReq;
import com.tria.dto.req.UserIdReq;
import com.tria.service.biz.DietaryRestrictionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 饮食限制客户端接口
 *
 * @author xc
 * @since 2024-01-05
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/client/dietary/restriction")
public class DietaryRestrictionController {

    private final DietaryRestrictionService dietaryRestrictionService;

    /**
     * 获取用户饮食限制列表
     *
     * @param req 用户ID（路径参数）
     * @return 饮食限制列表
     */
    @PostMapping("/query")
    public Result<List<DietaryRestrictionDTO>> getDietaryRestriction(@RequestBody UserIdReq req) {
        log.info("查询用户饮食限制，userId: {}", req.getUserId());
        req.doValidate();
        List<DietaryRestrictionDTO> result = dietaryRestrictionService.getDietaryRestriction(req.getUserId());
        return Result.success(result);
    }

    /**
     * 批量保存/更新用户饮食限制（自动去重逻辑建议放在 Service 层）
     *
     * @param req 饮食限制列表
     * @return 操作成功提示
     */
    @PostMapping("/add")
    public Result<Void> saveDietaryRestriction(@RequestBody SaveDietaryRestrictionReq req) {
        log.info("保存用户饮食限制，数量: {}", req.getDietaryRestriction().size());
        dietaryRestrictionService.saveDietaryRestriction(req.getDietaryRestriction());
        return Result.success(null);
    }

    /**
     * 删除指定饮食限制
     *
     * @param idReq 限制项ID
     * @return 操作成功提示
     */
    @PostMapping("/delete")
    public Result<Void> deleteDietaryRestriction(@RequestBody IdReq idReq) {
        log.info("删除饮食限制项，id: {}", idReq.getId());
        idReq.doValidate();
        dietaryRestrictionService.deleteDietaryRestriction(idReq.getId());
        return Result.success(null);
    }
}