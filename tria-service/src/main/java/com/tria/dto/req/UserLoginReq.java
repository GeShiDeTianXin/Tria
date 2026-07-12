package com.tria.dto.req;

import cn.hutool.core.util.StrUtil;
import com.tria.constant.AuthExceptionEnum;
import com.tria.constant.LoginTypeEnum;
import com.tria.dto.BaseReq;
import com.tria.util.CheckUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xc
 * @since 2024-01-05
 */
@Setter
@Getter
@Schema(description = "登录请求")
public class UserLoginReq extends BaseReq {

    @Schema(description = "登录方式：PASSWORD/SMS/WECHAT等")
    private LoginTypeEnum loginType;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "短信验证码")
    private String smsCode;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "邮箱验证码")
    private String emailCode;

    @Schema(description = "第三方身份类型")
    private String identityType;

    @Schema(description = "第三方身份标识")
    private String identityKey;

    @Schema(description = "图形验证码key")
    private String captchaKey;

    @Schema(description = "图形验证码")
    private String captchaCode;
    /**
     * 子类实现各自的校验逻辑
     */
    @Override
    protected void doValidate() {
        CheckUtil.check(LoginTypeEnum.isValidLoginType(loginType),"loginType值无效！");

        if (loginType == LoginTypeEnum.PASSWORD) {
            CheckUtil.check(StrUtil.isBlank(username), AuthExceptionEnum.PARAM_ERROR, "username");
            CheckUtil.check(StrUtil.isBlank(password), AuthExceptionEnum.PARAM_ERROR, "password");
        }

        if (loginType == LoginTypeEnum.SMS) {
            CheckUtil.check(StrUtil.isBlank(mobile), AuthExceptionEnum.PARAM_ERROR, "mobile");
            CheckUtil.check(StrUtil.isBlank(smsCode), AuthExceptionEnum.PARAM_ERROR, "smsCode");
        }

        if (loginType == LoginTypeEnum.EMAIL) {
            CheckUtil.check(StrUtil.isBlank(email), AuthExceptionEnum.PARAM_ERROR, "email");
            CheckUtil.check(StrUtil.isBlank(emailCode), AuthExceptionEnum.PARAM_ERROR, "emailCode");
        }

        if (loginType == LoginTypeEnum.OAUTH) {
            CheckUtil.check(StrUtil.isBlank(identityType), AuthExceptionEnum.PARAM_ERROR, "identityType");
            CheckUtil.check(StrUtil.isBlank(identityKey), AuthExceptionEnum.PARAM_ERROR, "identityKey");
        }
    }
}