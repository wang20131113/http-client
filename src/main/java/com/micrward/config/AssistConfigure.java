package com.micrward.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.micrward.assist.CountGenerator;
import com.micrward.assist.DefaultCountGenerator;

@Configuration
public class AssistConfigure {

	@Value("${schedule.pool.size:3}")
	private int schedulePoolSize;
	
	@Bean
	CountGenerator countGenerator(){
		return new DefaultCountGenerator();
	}
	
	@Bean	
	ScheduledExecutorService scheduledExecutorService(){
		return Executors.newScheduledThreadPool(this.schedulePoolSize);
	}
}
