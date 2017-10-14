package com.cfoom.springcloudzuuldynamicfilter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fly
 * created by fly on 17-10-15
 */
@ConfigurationProperties("zuul.filter")
@Data
public class FilterConfiguration {

    private String root;
    private Integer interval;
}
