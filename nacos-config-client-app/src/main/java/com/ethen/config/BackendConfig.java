package com.ethen.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 模拟后端应用相关配置
 *
 * @author ethenyang@126.com
 * @since 2022/10/05
 */
@Configuration
@EnableConfigurationProperties(RedisConfigProperties.class)
public class BackendConfig {
}
