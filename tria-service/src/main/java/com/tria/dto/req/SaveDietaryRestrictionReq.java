package com.tria.dto.req;

import cn.hutool.core.collection.CollUtil;
import com.tria.dto.BaseReq;
import com.tria.dto.model.DietaryRestrictionDTO;
import com.tria.util.CheckUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xc
 * @since 2024-01-05
 */
@Setter
@Getter
public class SaveDietaryRestrictionReq extends BaseReq {
   private List<DietaryRestrictionDTO> dietaryRestriction;

    /**
     * 子类实现各自的校验逻辑
     */
    @Override
    public void doValidate() {
        CheckUtil.check(CollUtil.isEmpty(dietaryRestriction),"dietaryRestriction值不能为空！");
    }
}
