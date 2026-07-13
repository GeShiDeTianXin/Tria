package com.tria.service.base;

import com.tria.entity.SysSequence;
import com.baomidou.mybatisplus.extension.service.IService;
public interface SysSequenceIService extends IService<SysSequence>{
    String getSequence(String bizType, String bizKey,Integer padLength, Long maxVal);
}
