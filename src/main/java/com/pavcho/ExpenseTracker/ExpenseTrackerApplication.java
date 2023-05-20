package com.pavcho.ExpenseTracker;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongock
@EnableMongoAuditing
@SpringBootApplication
public class ExpenseTrackerApplication {

//	@PostConstruct
//	public void init(){
//		// Setting Spring Boot SetTimeZone
//		//TODO get the user time zone from the browser - front end
//		TimeZone.setDefault(TimeZone.getTimeZone("EET"));
//	}

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);

	}

}
