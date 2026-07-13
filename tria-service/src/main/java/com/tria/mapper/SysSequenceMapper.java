package com.tria.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tria.entity.SysSequence;

public interface SysSequenceMapper extends BaseMapper<SysSequence> {
    int deleteByPrimaryKey(Long id);

    int insert(SysSequence record);

    int insertSelective(SysSequence record);

    SysSequence selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysSequence record);

    int updateByPrimaryKey(SysSequence record);
}