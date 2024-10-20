package com.example.integrationtests.apiClient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api-client.notifications")
@Getter
@Setter
public class NotificationClientConfig {
    private String url;
}
