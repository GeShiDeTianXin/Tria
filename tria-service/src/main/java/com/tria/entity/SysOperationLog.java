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
 * 操作日志表
 */
@Data
@TableName(value = "t_sys_operation_log")
public class SysOperationLog {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 租户ID
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 操作人用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 操作人账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 操作模块
     */
    @TableField(value = "`module`")
    private String module;

    /**
     * 操作描述
     */
    @TableField(value = "`operation`")
    private String operation;

    /**
     * 请求方法，如 com.xxx.UserController.add
     */
    @TableField(value = "`method`")
    private String method;

    /**
     * HTTP方法 GET/POST/PUT/DELETE
     */
    @TableField(value = "request_method")
    private String requestMethod;

    /**
     * 请求URL
     */
    @TableField(value = "request_url")
    private String requestUrl;

    /**
     * 请求参数
     */
    @TableField(value = "request_param")
    private String requestParam;

    /**
     * 返回结果
     */
    @TableField(value = "response_result")
    private String responseResult;

    /**
     * 操作状态 0-失败 1-成功
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 错误信息
     */
    @TableField(value = "error_msg")
    private String errorMsg;

    /**
     * 操作IP
     */
    @TableField(value = "operation_ip")
    private String operationIp;

    /**
     * 耗时（毫秒）
     */
    @TableField(value = "cost_time")
    private Long costTime;

    /**
     * 操作时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}