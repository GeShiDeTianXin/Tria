# Tria

单体 Spring Boot 项目脚手架，Spring Boot 2.7.15 + Java 8。

## 已包含

- Web (spring-boot-starter-web)
- 参数校验 (validation)
- MyBatis-Plus + MySQL + Druid连接池
- Redis (data-redis)
- Lombok
- 统一返回封装 `Result`
- 全局异常处理 `GlobalExceptionHandler` + 自定义业务异常 `BusinessException`
- 测试接口 `/test/ping`、`/test/error`

## 目录结构

```
src/main/java/com/tamara/demo
├─ controller     控制层
├─ service        业务接口
│  └─ impl        业务实现
├─ mapper         MyBatis-Plus Mapper接口
├─ entity         数据库实体
├─ dto            请求/响应数据传输对象
├─ config         各类配置类（Redis、MyBatis-Plus等）
├─ common         通用类（Result等）
└─ exception      异常相关
```

## 启动前准备

1. 修改 `application-dev.yml` 中数据库、Redis连接信息
2. 建库 `demo_db`（或改成你自己的库名）
3. `mvn clean package` 编译，或直接IDE运行 `DemoApplication`

## 验证

启动后访问：
- `GET http://localhost:8080/test/ping` → 返回统一封装的成功结果
- `GET http://localhost:8080/test/error?type=business` → 触发业务异常
- `GET http://localhost:8080/test/error` → 触发系统异常

## 后续扩展建议

按需逐步加入：分布式锁、幂等组件、数据脱敏、操作日志、HTTP客户端封装等，
可参考之前整理的自定义starter拆分思路，等模块稳定后再考虑是否独立成starter。
