package com.ethen.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 加载外部属性值
 *
 * @author ethenyang@126.com
 * @since 2022/02/17
 */
@PropertySources({@PropertySource("classpath:order-holder.properties")})
@Configuration
public class PropsConfig {
}
