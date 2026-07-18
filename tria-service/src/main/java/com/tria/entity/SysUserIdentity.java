package com.tria.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * $desc
 *
 * @author xc
 * @since 2024-01-05
 */
/**
 * 用户第三方身份绑定表
 */
@Data
@TableName(value = "t_sys_user_identity")
public class SysUserIdentity {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 关联t_sys_user.id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 第三方类型 WECHAT/ALIPAY/APPLE等
     */
    @TableField(value = "identity_type")
    private String identityType;

    /**
     * 第三方唯一标识,如openid
     */
    @TableField(value = "identity_key")
    private String identityKey;

    /**
     * 微信unionid,跨应用统一标识,可为空
     */
    @TableField(value = "union_id")
    private String unionId;

    /**
     * 第三方昵称,仅记录用,不作为业务昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 第三方头像,仅记录用
     */
    @TableField(value = "avatar")
    private String avatar;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}