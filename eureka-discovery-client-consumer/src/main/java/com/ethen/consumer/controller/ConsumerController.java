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
        String result = restTemplate.getForObject("http://eureka-discovery-client-provider/provider/v1/hello", String.class);
        if (log.isInfoEnabled()) {
            log.debug("helloRemote result {}", result);
        }
        return result;
    }
}
