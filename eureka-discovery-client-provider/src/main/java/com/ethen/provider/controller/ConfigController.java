package com.ethen.provider.controller;

import com.ethen.common.ResponseHelper;
import com.ethen.common.ResponseItem;
import com.ethen.provider.config.RedisConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/redis")
    public ResponseItem getRedisConfig() {
        return ResponseHelper.success(redisConfigProperties, env);
    }
}
