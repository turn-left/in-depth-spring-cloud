package com.ethen.member;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ethenyang@126.com
 * @since 2022/09/25
 */
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@SpringBootApplication
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class);
    }
}
