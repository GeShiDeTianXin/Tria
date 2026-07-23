package com.tria.api.controller;

import com.custom.common.result.Result;
import com.tria.dto.model.DictDataDTO;
import com.tria.service.biz.DictService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/client/dict")
public class DictController {
    private final DictService dictService;

    /**
     * 字典查询
     */
    @PostMapping("/getAllDict")
    public Result<Map<String, List<DictDataDTO>>> getAllDict() {
        return Result.success(dictService.getAllDict());
    }
}