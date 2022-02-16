package com.ethen.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ethenyang@126.com
 * @since 2022/02/16
 */
@SpringBootApplication
public class OrderApp {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(OrderApp.class);
        System.err.println(context);
    }
}
