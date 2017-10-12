package com.cfoom.springcloudfeignconsumer.service;

import org.springframework.stereotype.Component;

import com.cfoom.springcloudfeignconsumer.bean.User;

/**
 * Created by fly on 2017/10/12.
 */
@Component
public class DemoServiceFallback implements DemoService {
	@Override
	public String hello() {
		return "error";
	}

	@Override
	public String hello(String name) {
		return "error";
	}

	@Override
	public User hello(String name, Integer age) {
		return new User("unkown", -1);
	}

	@Override
	public String hello(User user) {
		return "error";
	}
}
