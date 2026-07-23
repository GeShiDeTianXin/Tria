package com.tria.dto.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xc
 * @since 2024-01-05
 */
@Setter
@Getter
public class HomeInfoDTO {
    private Long id;

    /**
     * 成员用户ID
     */
    private Long userId;

    /**
     * 租户ID(家园ID)
     */
    private Long tenantId;

    /**
     * 该用户对此家园的自定义称呼
     */
    private String tenantAlias;

    /**
     * 排序值,越小越靠前
     */
    private Integer sortOrder;

    /**
     * 是否为该用户默认展示的家园 0-否 1-是
     */
    private Integer isDefault;

    /**
     * 是否初始化默认家园 0-否 1-是,是就不允许修改
     */
    private Integer isInitDefault;
}
