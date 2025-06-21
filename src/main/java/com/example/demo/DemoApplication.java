package com.example.demo;

import com.example.demo.service.LLMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner onSuccessfulLoad(LLMService llmService) {
		return args -> {
			logger.info(llmService.chat("what is 3+4?"));
			logger.info(llmService.chat("what is the capital of Bangladesh?"));
			logger.debug("Demo Application successfully started.");
		};
	}

}
