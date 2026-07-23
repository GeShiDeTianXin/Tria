package com.tria.dto.req;

import cn.hutool.core.util.ObjUtil;
import com.tria.dto.BaseReq;
import com.tria.util.CheckUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserInfoReq extends BaseReq {

    @Schema(description = "用户id")
    private Long userId;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "性别")
    private Integer gender;
    @Schema(description = "生日")
    private LocalDate birthday;
    @Schema(description = "手机号")
    private String mobile;

    /**
     * 子类实现各自的校验逻辑
     */
    @Override
    public void doValidate() {
        CheckUtil.check(ObjUtil.isNull(userId),"userId值无效！");
    }

    // @Schema(description = "用户个人忌口列表")
    // private List<DietaryRestrictionDTO> list;
}