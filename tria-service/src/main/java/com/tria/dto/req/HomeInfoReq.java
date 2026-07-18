package com.tria.dto.req;

import cn.hutool.core.util.ObjUtil;
import com.tria.dto.BaseReq;
import com.tria.util.CheckUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xc
 * @since 2024-01-05
 */
@Getter
@Setter
public class HomeInfoReq extends BaseReq {

    private Long userId;

    /**
     * 子类实现各自的校验逻辑
     */
    @Override
    public void doValidate() {
        CheckUtil.check(ObjUtil.isNull(userId),"userId值无效！");
    }
}
