package com.cfoom.springclouddemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudDemoApplicationTests {

	@Test
	public void contextLoads() {
		List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		String url = "http://demo-service/demo/findList" + idList.stream().map(id -> "idList[]=" + id).collect(Collectors.joining("&"));
		System.out.println(url);
	}

}
