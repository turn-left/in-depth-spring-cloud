package com.ethen.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * spring cloud config server
 * <p>
 * 访问路径：
 * {protocol}:{ip}:{port}/{context-path}/{application}/{profile}/{label}
 * eg: git远程仓库master配置文件 in-depth-spring-cloud-dev.properties
 * http://localhost:7001/in-depth-spring-cloud/prod/master
 *
 * @author ethen
 * @since 2022/04/21
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }

}
