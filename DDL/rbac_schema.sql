-- ============================================================
-- 企业级 RBAC 权限系统数据库设计（无部门维度版本）
-- 技术栈：Spring Boot 3.2.5 + MyBatis-Plus + MySQL
-- ============================================================

-- ----------------------------
-- 1. 租户表
-- ----------------------------
CREATE TABLE sys_tenant (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_code     VARCHAR(32)  NOT NULL COMMENT '租户编码，业务侧唯一标识',
    tenant_name     VARCHAR(64)  NOT NULL COMMENT '租户名称',
    contact_name    VARCHAR(32)  COMMENT '联系人',
    contact_phone   VARCHAR(20)  COMMENT '联系电话',
    package_id      BIGINT       COMMENT '套餐ID（关联功能套餐表，可选）',
    expire_time     DATETIME     COMMENT '租户过期时间',
    domain          VARCHAR(128) COMMENT '绑定域名（多租户前端隔离用）',
    status          TINYINT      DEFAULT 1 COMMENT '状态 0-禁用 1-正常',
    deleted         TINYINT      DEFAULT 0 COMMENT '逻辑删除',
    create_time     DATETIME     DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY uk_tenant_code (tenant_code)
) COMMENT='租户表';

-- ----------------------------
-- 2. 用户表
-- ----------------------------
CREATE TABLE sys_user (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_id       BIGINT       NOT NULL COMMENT '租户ID',
    username        VARCHAR(64)  NOT NULL COMMENT '登录账号',
    password        VARCHAR(128) NOT NULL COMMENT 'BCrypt加密后密码',
    nickname        VARCHAR(64)  COMMENT '昵称',
    avatar          VARCHAR(255) COMMENT '头像地址',
    email           VARCHAR(64)  COMMENT '邮箱',
    mobile          VARCHAR(20)  COMMENT '手机号',
    gender          TINYINT      DEFAULT 0 COMMENT '性别 0-未知 1-男 2-女',
    user_type       TINYINT      DEFAULT 0 COMMENT '用户类型 0-普通用户 1-租户管理员 2-超级管理员(不受租户隔离)',
    status          TINYINT      DEFAULT 1 COMMENT '状态 0-禁用 1-正常',
    login_ip        VARCHAR(64)  COMMENT '最后登录IP',
    login_date      DATETIME     COMMENT '最后登录时间',
    pwd_update_time DATETIME     COMMENT '密码最后修改时间，用于强制定期改密',
    deleted         TINYINT      DEFAULT 0 COMMENT '逻辑删除',
    create_time     DATETIME     DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY uk_tenant_username (tenant_id, username, deleted)
) COMMENT='用户表';

-- ----------------------------
-- 3. 角色表
-- ----------------------------
CREATE TABLE sys_role (
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_id         BIGINT      NOT NULL COMMENT '租户ID',
    role_name         VARCHAR(64) NOT NULL COMMENT '角色名称',
    role_code         VARCHAR(64) NOT NULL COMMENT '角色标识，如 ROLE_ADMIN，代码里用它做权限判断',
    data_scope        TINYINT     DEFAULT 2 COMMENT '数据权限范围：1-全部数据 2-仅本人数据',
    order_num         INT         DEFAULT 0 COMMENT '排序',
    status            TINYINT     DEFAULT 1 COMMENT '状态 0-禁用 1-正常',
    remark            VARCHAR(255) COMMENT '备注',
    deleted           TINYINT     DEFAULT 0 COMMENT '逻辑删除',
    create_time       DATETIME    DEFAULT CURRENT_TIMESTAMP,
    update_time       DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY uk_tenant_role_code (tenant_id, role_code)
) COMMENT='角色表';

-- ----------------------------
-- 4. 菜单及权限表（不区分租户，系统级/套餐级管理）
-- ----------------------------
CREATE TABLE sys_menu (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    parent_id       BIGINT       DEFAULT 0 COMMENT '父菜单ID，0为根',
    menu_name       VARCHAR(64)  NOT NULL COMMENT '菜单名称',
    menu_type       TINYINT      NOT NULL COMMENT '菜单类型 1-目录 2-菜单 3-按钮/接口权限点',
    route_path      VARCHAR(128) COMMENT '前端路由path',
    component       VARCHAR(128) COMMENT '前端组件路径',
    perms           VARCHAR(128) COMMENT '权限标识，如 system:user:add',
    icon            VARCHAR(64)  COMMENT '图标',
    order_num       INT          DEFAULT 0 COMMENT '排序',
    visible         TINYINT      DEFAULT 1 COMMENT '前端是否显示 0-隐藏 1-显示',
    status          TINYINT      DEFAULT 1 COMMENT '状态 0-禁用 1-正常',
    deleted         TINYINT      DEFAULT 0 COMMENT '逻辑删除',
    create_time     DATETIME     DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) COMMENT='菜单及权限表';

-- ----------------------------
-- 5. 用户角色关联表
-- ----------------------------
CREATE TABLE sys_user_role (
    user_id     BIGINT NOT NULL COMMENT '用户ID',
    role_id     BIGINT NOT NULL COMMENT '角色ID',
    PRIMARY KEY (user_id, role_id)
) COMMENT='用户角色关联表';

-- ----------------------------
-- 6. 角色菜单关联表
-- ----------------------------
CREATE TABLE sys_role_menu (
    role_id     BIGINT NOT NULL COMMENT '角色ID',
    menu_id     BIGINT NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (role_id, menu_id)
) COMMENT='角色菜单关联表';

-- ----------------------------
-- 7. 登录日志表
-- ----------------------------
CREATE TABLE sys_login_log (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_id       BIGINT       COMMENT '租户ID',
    username        VARCHAR(64)  COMMENT '登录账号',
    login_ip        VARCHAR(64)  COMMENT '登录IP',
    login_location  VARCHAR(128) COMMENT '登录地点',
    browser         VARCHAR(64)  COMMENT '浏览器类型',
    os              VARCHAR(64)  COMMENT '操作系统',
    status          TINYINT      COMMENT '登录状态 0-失败 1-成功',
    msg             VARCHAR(255) COMMENT '提示信息，如密码错误/账号锁定',
    login_time      DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
    KEY idx_tenant_time (tenant_id, login_time)
) COMMENT='登录日志表';

-- ----------------------------
-- 8. 操作日志表（审计，可选）
-- ----------------------------
CREATE TABLE sys_operation_log (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_id       BIGINT       COMMENT '租户ID',
    user_id         BIGINT       COMMENT '操作人用户ID',
    username        VARCHAR(64)  COMMENT '操作人账号',
    module          VARCHAR(64)  COMMENT '操作模块',
    operation       VARCHAR(128) COMMENT '操作描述',
    method          VARCHAR(255) COMMENT '请求方法，如 com.xxx.UserController.add',
    request_method  VARCHAR(16)  COMMENT 'HTTP方法 GET/POST/PUT/DELETE',
    request_url     VARCHAR(255) COMMENT '请求URL',
    request_param   TEXT         COMMENT '请求参数',
    response_result TEXT         COMMENT '返回结果',
    status          TINYINT      COMMENT '操作状态 0-失败 1-成功',
    error_msg       VARCHAR(500) COMMENT '错误信息',
    operation_ip    VARCHAR(64)  COMMENT '操作IP',
    cost_time       BIGINT       COMMENT '耗时（毫秒）',
    create_time     DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
    KEY idx_tenant_time (tenant_id, create_time)
) COMMENT='操作日志表';

-- ----------------------------
-- 9. 第三方登录身份绑定表
-- ----------------------------
CREATE TABLE sys_user_identity (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    tenant_id       BIGINT       NOT NULL COMMENT '租户ID',
    user_id         BIGINT       NOT NULL COMMENT '关联sys_user.id',
    identity_type   VARCHAR(20)  NOT NULL COMMENT '第三方类型：WECHAT、GITHUB、QQ等',
    identity_key    VARCHAR(128) NOT NULL COMMENT '第三方唯一标识，如openid/unionid',
    nickname        VARCHAR(64)  COMMENT '第三方平台昵称（可选，登录时展示用）',
    create_time     DATETIME     DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_type_key (identity_type, identity_key),
    KEY idx_user (user_id)
) COMMENT='第三方登录身份绑定表';