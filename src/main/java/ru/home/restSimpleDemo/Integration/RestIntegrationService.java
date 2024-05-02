package ru.home.restSimpleDemo.Integration;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class RestIntegrationService extends BaseIntegrationService{
    private final RestTemplate restTemplate;

    public RestIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <Rq, Rs> Rs sendHttpRequest(String url, HttpMethod httpMethod, HttpEntity<Rq> httpEntity, Class<Rs> clazz){
        return   invokeIntegrationRequest(arg -> {
                    ResponseEntity<Rs> response = restTemplate.exchange(url, httpMethod, arg ,clazz);
                    return response.getBody();

        }
        , httpEntity);

    }
}
