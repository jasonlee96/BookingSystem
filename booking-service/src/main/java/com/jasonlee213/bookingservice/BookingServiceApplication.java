package com.jasonlee213.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.jasonlee213.bookingservice")
@EntityScan( basePackages = {"com.jasonlee213.bookingservice.models"} )
//@EnableConfigurationProperties(AppSetting.class)
@EnableScheduling
@EnableAsync
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
