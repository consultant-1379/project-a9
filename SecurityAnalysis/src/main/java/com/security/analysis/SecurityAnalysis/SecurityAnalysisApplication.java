package com.security.analysis.SecurityAnalysis;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecurityAnalysisApplication {

	public static void main(String[] args) throws JsonProcessingException {
		ApplicationContext context = SpringApplication.run(SecurityAnalysisApplication.class, args);

	}

}
