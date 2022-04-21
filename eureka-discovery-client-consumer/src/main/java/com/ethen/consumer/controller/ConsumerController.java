package com.ethen.consumer.controller;

import com.ethen.common.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${from}")
    private String from;

    @RequestMapping("/remote/hello")
    public Object helloRemote(String name, String greetings) {
        String urlTemplate = "http://eureka-discovery-client-provider/provider/v1/hello?name=%s&greetings=%s";
        String result = restTemplate.getForObject(String.format(urlTemplate, name, greetings), String.class);
        if (log.isInfoEnabled()) {
            log.info("helloRemote result {}", result);
        }
        return result;
    }

    @GetMapping("/config")
    public Object getConfig() {
        return from;
    }
}
