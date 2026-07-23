package com.tria.convert;

import com.tria.dto.model.DictDataDTO;
import com.tria.entity.SysDictData;
import org.mapstruct.Mapper;

/**
 * @author xc
 * @since 2024-01-05
 */
@Mapper(componentModel = "spring")
public interface DictConvert {
    DictDataDTO toDictDataDTO(SysDictData sysDictData);
}