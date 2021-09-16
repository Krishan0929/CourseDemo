package com.CourseDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseDemoApplication {
  private static Logger logger= LoggerFactory.getLogger(CourseDemoApplication.class.getName());
	public static void main(String[] args) {

		SpringApplication.run(CourseDemoApplication.class, args);
		logger.error("[getMessage] error shown");
		logger.warn("[getMessage] warn shown");
		logger.info("[getMessage] info message shown");
		logger.debug("[getMessage] debug message shown");
		logger.trace("[getMessage] trace message shown");
	}

}
