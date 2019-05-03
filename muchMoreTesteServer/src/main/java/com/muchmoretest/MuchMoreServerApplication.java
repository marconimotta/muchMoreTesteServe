package com.muchmoretest;

import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class MuchMoreServerApplication {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); // It will set UTC timezone
		System.out.println("Spring boot application running in UTC timezone :" + new Date()); // It will print UTC
	}

	public static void main(String[] args) {
		SpringApplication.run(MuchMoreServerApplication.class, args);
	}
	
	@Bean
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(2);
	}
}
