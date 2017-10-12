package com.cfoom.springcloudfeignconsumer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by fly on 2017/10/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private Integer age;

}
