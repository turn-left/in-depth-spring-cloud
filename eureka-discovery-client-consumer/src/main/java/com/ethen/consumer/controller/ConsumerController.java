package com.ethen.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/remote/hello")
    public Object helloRemote(String name, String greetings) {
        String urlTemplate = "http://eureka-discovery-client-provider/provider/v1/hello?name=%s&greetings=%s";
        String result = restTemplate.getForObject(String.format(urlTemplate, name, greetings), String.class);
        if (log.isInfoEnabled()) {
            log.info("helloRemote result {}", result);
        }
        return result;
    }
}
