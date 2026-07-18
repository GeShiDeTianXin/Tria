package com.tria.dto.model;


import lombok.Data;

@Data
public class WxSessionResult {
    private String openid;
    private String sessionKey; // 注意微信返回的是 session_key,需要@JsonProperty或JSONUtil配置映射
    private String unionid;
    private Integer errcode;
    private String errmsg;
}