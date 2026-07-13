package com.tria.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tria.entity.SysSequence;
import com.tria.mapper.SysSequenceMapper;
import com.tria.service.base.SysSequenceIService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class SysSequenceServiceImpl extends ServiceImpl<SysSequenceMapper, SysSequence> implements SysSequenceIService {

    private static final int MAX_RETRY = 10;

    @Override
    public String getSequence(String bizType, String bizKey, Integer padLength, Long maxVal) {
        SysSequence record = getOrInit(bizType, bizKey, padLength, maxVal);

        for (int i = 0; i < MAX_RETRY; i++) {
            long newVal = record.getCurrentVal() + record.getStep();

            // 上限校验：maxVal 为空或<=0 表示不限制
            if (record.getMaxVal() != null && record.getMaxVal() > 0 && newVal > record.getMaxVal()) {
                throw new IllegalStateException(
                        String.format("序号已达上限：%s/%s，最大值=%d", bizType, bizKey, record.getMaxVal())
                );
            }

            record.setCurrentVal(newVal);

            // updateById 依赖 @Version 乐观锁字段，自动带版本号校验，冲突时返回 false
            boolean success = updateById(record);
            if (success) {
                return format(newVal, record.getPadLength());
            }

            // 更新失败说明有并发冲突，重新查最新记录再重试
            record = getOne(bizType, bizKey);
            if (record == null) {
                throw new IllegalStateException("序号记录异常丢失：" + bizType + "/" + bizKey);
            }
        }
        throw new IllegalStateException("序号生成失败，重试次数超限：" + bizType + "/" + bizKey);
    }

    private SysSequence getOrInit(String bizType, String bizKey, Integer padLength, Long maxVal) {
        SysSequence record = getOne(bizType, bizKey);
        if (record != null) {
            return record;
        }
        // 不存在则初始化一行
        SysSequence newRecord = new SysSequence();
        newRecord.setBizType(bizType);
        newRecord.setBizKey(bizKey);
        newRecord.setPadLength(padLength);
        newRecord.setMaxVal(maxVal);
        newRecord.setCurrentVal(0L);
        newRecord.setStep(1);

        try {
            save(newRecord); // 依赖 uk_biz_type_key 唯一索引拦截并发重复插入
            return newRecord;
        } catch (DuplicateKeyException e) {
            // 极端并发下，两个线程同时判断"不存在"，只有一个能插入成功
            // 另一个会插入失败，此时重新查一次即可拿到已插入的记录
            SysSequence exist = getOne(bizType, bizKey);
            if (exist == null) {
                throw new IllegalStateException("并发初始化异常：" + bizType + "/" + bizKey, e);
            }
            return exist;
        }
    }

    /**
     * 只按唯一索引 (bizType, bizKey) 查询，padLength/maxVal 是配置属性，不参与查询条件
     */
    private SysSequence getOne(String bizType, String bizKey) {
        return getOne(
                new LambdaQueryWrapper<SysSequence>()
                        .eq(SysSequence::getBizType, bizType)
                        .eq(SysSequence::getBizKey, bizKey)
        );
    }

    /**
     * 按 padLength 补零，padLength 为空或<=0 时原样返回
     */
    private String format(long val, Integer padLength) {
        if (padLength == null || padLength <= 0) {
            return String.valueOf(val);
        }
        return String.format("%0" + padLength + "d", val);
    }
}