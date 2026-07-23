package com.tria.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DietaryRestrictionDTO {
    /**
     * 用户个人忌口表主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 食材ID，关联食材库
     */
    private Long ingredientId;

    /**
     * 食材名称（冗余快照）
     */
    private String ingredientName;

    /**
     * 忌口类型 1-过敏 2-不喜欢 3-饮食限制
     */
    private Integer restrictionType;

    /**
     * 是否长期忌口 0-否 1-是
     */
    private Integer isLongTerm;

    private LocalDate startDate;
    private LocalDate endDate;
    /**
     * 状态 0-已失效 1-生效中
     */
    private Integer status;
}
