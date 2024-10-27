package com.example.integrationtests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry // To enable retry on failure in NotificationClient
public class IntegrationTestsApplication {
  public static void main(String[] args) {
    SpringApplication.run(IntegrationTestsApplication.class, args);
  }
}
