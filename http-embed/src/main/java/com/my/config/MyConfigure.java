package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.assist.CountGenerator;
import com.my.assist.DefaultCountGenerator;

@Configuration
public class MyConfigure {

	@Bean
	CountGenerator countGenerator(){
		return new DefaultCountGenerator();
	}
}
