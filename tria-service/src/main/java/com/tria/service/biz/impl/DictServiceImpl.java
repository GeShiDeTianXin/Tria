package com.tria.service.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.tria.convert.DictConvert;
import com.tria.dto.model.DictDataDTO;
import com.tria.entity.SysDictData;
import com.tria.service.base.SysDictDataIService;
import com.tria.service.biz.DictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xc
 * @since 2024-01-05
 */
@Service
@AllArgsConstructor
public class DictServiceImpl implements DictService {

    private final SysDictDataIService sysDictDataIService;
    private final DictConvert dictConvert;

    /**
     * 查询全部字典数据，按 dictType 分组
     */
    @Override
    public Map<String, List<DictDataDTO>> getAllDict() {
        List<SysDictData> list = sysDictDataIService.list();
        if (CollUtil.isEmpty(list)) {
            return new HashMap<>();
        }
        return list.stream()
                .map(dictConvert::toDictDataDTO)
                .collect(Collectors.groupingBy(DictDataDTO::getDictType));
    }
}
