package com.cfoom.springclouddemo.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.cfoom.springclouddemo.bean.User;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        log.info(localServiceInstance.getHost() + ":" + localServiceInstance.getServiceId() + ":" + localServiceInstance.getUri().toString());
        return "Hello world!!!";
    }

    @GetMapping("hello1")
    public String hello(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping("hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("hello3")
    public String hello(@RequestBody User user) {
        return "hello " + user.getName() + ", " + user.getAge();
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
