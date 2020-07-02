package com.rahul.websockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan("com.rahul.websockets")
public class WebsocketsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebsocketsApplication.class, args);
		CustomSocketScheduler customSocketScheduler = (CustomSocketScheduler) applicationContext.getBean("customSocketScheduler");
		customSocketScheduler.alive();
	}

}
