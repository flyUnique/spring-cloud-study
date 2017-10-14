package com.cfoom.springcloudzuul;

import com.cfoom.springcloudzuul.filter.CustomerFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;

@SpringCloudApplication
@EnableZuulProxy
public class SpringCloudZuulApplication {

	public static void main(String[] args) {
        FilterProcessor.setProcessor(new CustomerFilterProcessor());
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}

//    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "$<version>/$<name>");
    }
}
