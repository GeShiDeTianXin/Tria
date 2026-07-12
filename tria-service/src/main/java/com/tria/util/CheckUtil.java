package com.tria.util;

import com.custom.common.exception.BusinessException;
import com.custom.common.exception.IExceptionCode;
import com.tria.constant.AuthExceptionEnum;

import java.text.MessageFormat;

/**
 * @author xc
 * @since 2024-01-05
 */
public class CheckUtil {

    public static void check(boolean result, IExceptionCode exceptionCode, Object... args) {
        if (!result) {
            throw new BusinessException(exceptionCode.getCode(), MessageFormat.format(exceptionCode.getMessage(),args));
        }
    }

    /**
     * 校验条件，不满足则抛出业务异常
     *
     * @param result  校验结果，true表示校验通过
     * @param message 校验失败提示信息
     */
    public static void check(boolean result, String message) {
        if (!result) {
            throw new BusinessException(AuthExceptionEnum.PARAM_ERROR.getCode(),
                    MessageFormat.format(AuthExceptionEnum.PARAM_ERROR.getMessage(), message)
            );
        }
    }

    /**
     * 校验条件，不满足则抛出业务异常（带自定义code）
     */
    public static void check(boolean result, int code, String message) {
        if (!result) {
            throw new BusinessException(code, message);
        }
    }
}
