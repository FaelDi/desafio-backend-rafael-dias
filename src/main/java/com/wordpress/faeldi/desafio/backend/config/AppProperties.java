package com.wordpress.faeldi.desafio.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "url")
@Data
public class AppProperties {
    private String authorizeServiceUrl;
    private String notificationServiceUrl;
}
