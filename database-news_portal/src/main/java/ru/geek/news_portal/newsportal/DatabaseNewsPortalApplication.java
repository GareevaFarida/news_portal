package ru.geek.news_portal.newsportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("private.properties")
public class DatabaseNewsPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseNewsPortalApplication.class, args);
    }

}
