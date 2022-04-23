package com.ethen.provider.controller;

import com.ethen.common.ResponseHelper;
import com.ethen.common.ResponseItem;
import com.ethen.provider.config.RedisConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring cloud config 实战
 * <p>
 * <li>1.动态获取配置项</li>
 * <li>2.实时刷新</li>
 * <li>3.@value与ConfigurationProperties的区别</li>
 */
@RestController
@RequestMapping("/v1/config")
public class ConfigController extends EnvBasicController {

    @Autowired
    private RedisConfigProperties redisConfigProperties;

    @Value("${redis.cluster.instance-list}")
    private String redisInstances;

    @GetMapping("/redis")
    public ResponseItem getRedisConfig() {
        return ResponseHelper.success(redisConfigProperties, env);
    }

    @GetMapping("/redis/instances")
    public ResponseItem getRedisInstances() {
        return ResponseHelper.success(redisInstances);
    }
}
