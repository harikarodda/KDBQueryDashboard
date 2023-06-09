package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication
@EnableConfigurationProperties
public class KdbQueryApp {
    public static void main(String[] args) {
        SpringApplication.run(KdbQueryApp.class, args);
    }
}

