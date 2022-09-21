package com.ethen.provider.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置中心实践
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "redis")
public class RedisConfigProperties {

    private RedisProps sentinel;

    private RedisProps cluster;

    @Getter
    @Setter
    @ToString
    public static class RedisProps {

        private String name;

        private String instanceList;

        private String auth;

        private Boolean active = Boolean.FALSE;
    }

}
