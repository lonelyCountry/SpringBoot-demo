package com.lonelycountry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Springboot02SchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02SchedulingTasksApplication.class, args);
	}
}
