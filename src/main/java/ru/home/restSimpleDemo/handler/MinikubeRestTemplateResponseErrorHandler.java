package ru.home.restSimpleDemo.handler;

import ru.home.restSimpleDemo.exception.MinikubeHttpClientErrorException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MinikubeRestTemplateResponseErrorHandler extends  BaseRestTemplateErrorHandler{
    public void handleError(ClientHttpResponse response) throws IOException {
        logError();
        throw new MinikubeHttpClientErrorException(response.getStatusCode(), response.getStatusText());

    }
}
