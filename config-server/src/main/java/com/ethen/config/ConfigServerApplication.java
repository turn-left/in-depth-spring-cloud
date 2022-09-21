package com.ethen.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * spring cloud config server
 * <p>
 * 访问路径：
 * {protocol}:{ip}:{port}/{context-path}/{application}/{profile}/{label}
 * eg: git远程仓库master配置文件 in-depth-spring-cloud-dev.properties
 * http://localhost:7001/in-depth-spring-cloud/prod/master
 * <p>
 * Spring Cloud Config 有它的一套访问规则，我们通过这套规则在浏览器上直接访问就可以。
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * <p>
 * spring cloud config自动刷新{@link -> https://cloud.tencent.com/developer/article/1474037}
 * fixme @value不会实现刷新？？
 *
 * @author ethen
 * @since 2022/04/21
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApplication.class);

    }

}
