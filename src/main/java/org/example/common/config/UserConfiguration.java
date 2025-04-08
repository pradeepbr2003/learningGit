package org.example.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:user.properties")
@ConfigurationProperties(prefix = "user")
@Data
@Configuration
public class UserConfiguration {
    private String[] skillSet;
    private String[] username;
}
