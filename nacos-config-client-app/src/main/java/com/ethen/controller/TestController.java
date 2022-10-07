package com.ethen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * nacos config 刷新demo
 *
 * @author ethenyang@126.com
 * @since 2022/10/05
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @GetMapping("/config")
    public Object getConfigValue() {
        return "name=" + name + ",age=" + age;
    }

    @Scheduled(cron = "5 * * * * ?")
    public void executeFixed() {
        System.err.println("executeFixed 定时任务执行：" + ZonedDateTime.now());
    }
}
