package com.tria.util;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IpUtils {

    /**
     * 获取客户端真实IP
     */
    public static String getClientIp(HttpServletRequest request) {
        if (request == null) {
            return null;
        }

        // 1. 先从标准代理头获取
        String ip = request.getHeader("X-Forwarded-For");
        if (isValidIp(ip)) {
            // X-Forwarded-For 可能包含多个IP（代理链），取第一个非unknown的
            ip = ip.split(",")[0].trim();
            if (isValidIp(ip)) {
                return ip;
            }
        }

        // 2. 尝试其他代理头
        ip = request.getHeader("X-Real-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("Proxy-Client-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_CLIENT_IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (isValidIp(ip)) {
            return ip;
        }

        // 3. 兜底：直接获取
        ip = request.getRemoteAddr();

        // 4. 本地/内网特殊处理
        if ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip)) {
            ip = "127.0.0.1";
        }

        return ip;
    }

    /**
     * 校验IP是否有效
     */
    private static boolean isValidIp(String ip) {
        return StrUtil.isNotBlank(ip)
                && !"unknown".equalsIgnoreCase(ip)
                && !"null".equalsIgnoreCase(ip);
    }
}