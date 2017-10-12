package com.cfoom.springcloudribbonconsumer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by fly on 2017/10/9.
 */
@Service
@Slf4j
public class DemoService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallBack")
	public String hello() {
		return restTemplate.getForEntity("http://demo-service/demo/hello", String.class).getBody();
	}

	public String helloFallBack() {
		return "error";
	}

	@HystrixCollapser(batchMethod = "findList", collapserProperties = {
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
	})
	public String find(Integer id) {
		return restTemplate.getForEntity("http://demo-service/demo/find?id={id}", String.class, id).getBody();
	}

	@HystrixCommand
	public List<String> findList(List<Integer> idList) {
		String url = "http://demo-service/demo/findList";
		if (!idList.isEmpty()) {
			url += "?" + idList.stream().map(id -> "idList[]=" + id).collect(Collectors.joining("&"));
		}
		log.info("collapser invoked , url is {}", url);
		return restTemplate.getForEntity(url, List.class).getBody();
	}
}
