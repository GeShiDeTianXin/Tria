package com.tria.dto.req;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.tria.constant.AuthExceptionEnum;
import com.tria.constant.LoginTypeEnum;
import com.tria.constant.RegisterTypeEnum;
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
@Schema(description = "注册请求")
public class UserRegisterReq extends BaseReq {

    @Schema(description = "MOBILE(手机号注册) / EMAIL(邮箱注册) / USERNAME(账号密码注册，需管理员开放)")
    private RegisterTypeEnum registerType;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "确认密码")
    private String confirmPassword;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "短信验证码")
    private String smsCode;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "邮箱验证码")
    private String emailCode;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "图形验证码key")
    private String captchaKey;

    @Schema(description = "图形验证码")
    private String captchaCode;

    @Schema(description = "是否同意用户协议/隐私政策，必须为true")
    private String agreement;
    /**
     * 子类实现各自的校验逻辑
     */
    @Override
    public void doValidate() {
        CheckUtil.check(ObjUtil.isNull(registerType),"registerType值无效！");

        if (registerType == RegisterTypeEnum.USERNAME) {
            CheckUtil.check(StrUtil.isBlank(username), AuthExceptionEnum.PARAM_ERROR, "username");
            CheckUtil.check(StrUtil.isBlank(password), AuthExceptionEnum.PARAM_ERROR, "password");
            CheckUtil.check(StrUtil.isBlank(confirmPassword), AuthExceptionEnum.PARAM_ERROR, "confirmPassword");
            CheckUtil.check(!password.equals(confirmPassword), "两次密码不一致！");
        }

        if (registerType == RegisterTypeEnum.MOBILE) {
            CheckUtil.check(StrUtil.isBlank(mobile), AuthExceptionEnum.PARAM_ERROR, "mobile");
            CheckUtil.check(StrUtil.isBlank(smsCode), AuthExceptionEnum.PARAM_ERROR, "smsCode");
        }

        if (registerType == RegisterTypeEnum.EMAIL) {
            CheckUtil.check(StrUtil.isBlank(email), AuthExceptionEnum.PARAM_ERROR, "email");
            CheckUtil.check(StrUtil.isBlank(emailCode), AuthExceptionEnum.PARAM_ERROR, "emailCode");
        }
    }
}