package com.ethen.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 模拟配置项
 *
 * @author ethenyang@126.com
 * @since 2022/10/05
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "redis.cluster")
public class RedisConfigProperties {
    private String nodes;
    private String token;
    private String expire;
    private String policy;
}
