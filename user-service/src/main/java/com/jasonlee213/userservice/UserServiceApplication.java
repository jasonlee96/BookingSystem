package com.jasonlee213.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.jasonlee213.userservice")
@EntityScan( basePackages = {"com.jasonlee213.userservice.entities"} )
//@EnableConfigurationProperties(AppSetting.class)
@EnableScheduling
@EnableAsync
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
