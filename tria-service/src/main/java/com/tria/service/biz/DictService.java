package com.tria.service.biz;

import com.tria.dto.model.DictDataDTO;

import java.util.List;
import java.util.Map;

/**
 * @author xc
 * @since 2024-01-05
 */
public interface DictService {
    /**
     * 查询全部字典数据，按 dictType 分组
     */
    Map<String, List<DictDataDTO>> getAllDict();
}
