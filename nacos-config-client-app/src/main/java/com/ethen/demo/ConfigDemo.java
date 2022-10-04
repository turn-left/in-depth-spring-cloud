package com.ethen.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * nacos配置中心demo
 *
 * @author ethenyang@126.com
 * @since 2022/10/04
 */
public class ConfigDemo {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String host = "192.168.56.20";
        String dataId = "nacos-config-demo.yml";
        String group = "DEFAULT_GROUP";
        long timeout = 5000L;
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, host);

        ConfigService configService = NacosFactory.createConfigService(properties);

        String config = configService.getConfig(dataId, group, 5000L);

        System.err.println(config);

        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("receiveConfigInfo::" + configInfo);
            }
        });


        // 发布配置
        configService.publishConfig(dataId, group, "common.database.port=3306", ConfigType.PROPERTIES.getType());
        TimeUnit.SECONDS.sleep(3L);

        String configNew = configService.getConfig(dataId, group, timeout);

        System.out.println(configNew);

    }
}
