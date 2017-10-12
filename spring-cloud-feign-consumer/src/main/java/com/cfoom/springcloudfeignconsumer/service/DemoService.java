package com.cfoom.springcloudfeignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.cfoom.springcloudfeignconsumer.bean.User;

/**
 * Created by fly on 2017/10/12.
 */
@FeignClient(value = "demo-service", fallback = DemoServiceFallback.class)
public interface DemoService {

	@RequestMapping("/demo/hello")
	String hello();

	@GetMapping("/demo/hello1")
	String hello(@RequestParam("name") String name);

	@GetMapping("/demo/hello2")
	User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@PostMapping("/demo/hello3")
	String hello(@RequestBody User user);
}
