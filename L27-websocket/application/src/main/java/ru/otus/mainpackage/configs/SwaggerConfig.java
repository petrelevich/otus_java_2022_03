package ru.otus.mainpackage.configs;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //http://localhost:8080/swagger-ui/index.html

    @Bean
    public GroupedOpenApi publicApi(@Value("${application.rest.api.prefix}/v1")String prefix) {
        return GroupedOpenApi.builder()
                .group("DemoApplication")
                .pathsToMatch(String.format("%s/**", prefix))
                .build();
    }
}
