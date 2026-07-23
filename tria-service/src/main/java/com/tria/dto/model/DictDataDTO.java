package com.tria.dto.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典数据项 DTO
 */
@Data
public class DictDataDTO implements Serializable {



    /**
     * 所属字典类型编码，关联t_sys_dict_type.dict_type
     */
    private String dictType;

    /**
     * 字典标签，前端展示文案，如 男、过敏
     */
    private String dictLabel;

    /**
     * 字典键值，业务存储和判断用，如 1、2
     */
    private String dictValue;

    /**
     * 排序值，越小越靠前
     */
    private Integer sortOrder;

    /**
     * 是否为该字典的默认选中项 0-否 1-是
     */
    private Integer isDefault;

    /**
     * 前端展示的样式标记，如颜色/图标类名（可选）
     */
    private String cssClass;

    /**
     * 状态 0-禁用 1-正常
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}