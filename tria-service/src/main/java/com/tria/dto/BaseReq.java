package com.tria.dto;

/**
 * @author xc
 * @since 2024-01-05
 */
public abstract class BaseReq {
    /**
     * 子类实现各自的校验逻辑
     */
    public abstract void doValidate();
}
