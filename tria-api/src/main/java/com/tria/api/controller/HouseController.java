package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.req.UserIdReq;
import com.tria.dto.res.HomeInfoRes;
import com.tria.service.biz.HouseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/client/house")
public class HouseController {
    private final HouseService houseService;

    /**
     * 家园查询
     */
    @PostMapping("/query")
    public Result<HomeInfoRes> queryHomeInfo(@RequestBody UserIdReq req) {
        log.info("进入house/query接口, req={}", req);
        req.doValidate();
        return Result.success(houseService.getHomeInfoByUserId(req.getUserId()));
    }
}