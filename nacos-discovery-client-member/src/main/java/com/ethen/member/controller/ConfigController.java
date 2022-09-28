package com.ethen.member.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos config hello
 *
 * @author ethenyang@126.com
 * @since 2022/09/25
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @GetMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}
