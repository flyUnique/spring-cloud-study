package com.cfoom.springclouddemo.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

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

    @GetMapping("/find")
    public String find(Integer id) {
        return String.valueOf(id);
    }

    @GetMapping("/findList")
    public List<String> findList(@RequestParam("idList[]") List<Integer> idList) {
        return idList.parallelStream().map(String::valueOf).collect(Collectors.toList());
    }
}
