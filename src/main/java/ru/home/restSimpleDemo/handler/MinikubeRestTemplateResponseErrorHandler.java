package ru.home.restSimpleDemo.handler;

import exception.BaseHttpClientErrorException;
import exception.MinikubeHttpClientErrorException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MinikubeRestTemplateResponseErrorHandler extends  BaseRestTemplateErrorHandler{
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new MinikubeHttpClientErrorException(response.getStatusCode(), response.getStatusText());

    }
}
