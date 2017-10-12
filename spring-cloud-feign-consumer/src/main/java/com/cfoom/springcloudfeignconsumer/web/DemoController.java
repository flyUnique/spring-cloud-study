package com.cfoom.springcloudfeignconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfoom.springcloudfeignconsumer.bean.User;
import com.cfoom.springcloudfeignconsumer.service.DemoService;

/**
 * Created by fly on 2017/10/12.
 */
@RestController
@RequestMapping("feign")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping("hello")
	public String hello() {
		return demoService.hello();
	}

	@GetMapping("hello2")
	public String hello2() {
		StringBuilder sb = new StringBuilder();
		sb.append(demoService.hello()).append("\n")
				.append(demoService.hello("fly")).append("\n")
				.append(demoService.hello("fly", 29)).append("\n")
				.append(demoService.hello(new User("fly", 30)));
		return sb.toString();
	}
}
