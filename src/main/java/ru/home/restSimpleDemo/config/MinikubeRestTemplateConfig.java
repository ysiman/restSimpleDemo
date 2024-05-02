package ru.home.restSimpleDemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.home.restSimpleDemo.handler.MinikubeRestTemplateResponseErrorHandler;

import java.time.Duration;

@Configuration
public class MinikubeRestTemplateConfig {
    private final String baseUrl = "http://192.168.0.0";
    @Bean
    public RestTemplate minikubeRestTemplate(MinikubeRestTemplateResponseErrorHandler errorHandler) {
        RestTemplateBuilder rtb = new RestTemplateBuilder();
        RestTemplate restTemplate =rtb.setConnectTimeout(Duration.ofSeconds(100))
                .setReadTimeout(Duration.ofSeconds(100))
                .errorHandler(errorHandler)
                .build();
        restTemplate.setUriTemplateHandler( new DefaultUriBuilderFactory(baseUrl));
        return restTemplate;
    }
}
