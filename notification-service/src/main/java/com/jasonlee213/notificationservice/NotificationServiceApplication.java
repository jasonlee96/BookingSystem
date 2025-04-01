package com.jasonlee213.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.jasonlee213.notificationservice")
//@EntityScan( basePackages = {"com.jasonlee213.notificationservice.entities"} )
//@EnableConfigurationProperties(AppSetting.class)
//@EnableScheduling
@EnableAsync
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
