package com.cfoom.springclouddemo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String index() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        log.info(localServiceInstance.getHost() + ":" + localServiceInstance.getServiceId() + ":" + localServiceInstance.getUri().toString());
        return "Hello world!!!";
    }
}
