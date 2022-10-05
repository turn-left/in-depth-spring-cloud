package com.ethen;

import com.ethen.config.RedisConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * nacos配置中心实战
 *
 * @author ethenyang@126.com
 * @since 2022/10/05
 */
@SpringBootApplication
public class ConfigApp {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ConfigApp.class);
        String salt = context.getEnvironment().getProperty("salt");
        System.err.println("get props:" + salt);
        Object redisConfigProperties = context.getBeansOfType(RedisConfigProperties.class);
        System.err.println(redisConfigProperties);


        while (true) {
            Map<String, RedisConfigProperties> map = context.getBeansOfType(RedisConfigProperties.class);
            System.err.println("now:" + map);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
