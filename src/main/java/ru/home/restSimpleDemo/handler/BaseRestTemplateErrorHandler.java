package ru.home.restSimpleDemo.handler;

import lombok.extern.slf4j.Slf4j;
import ru.home.restSimpleDemo.exception.BaseHttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
@Slf4j
public class BaseRestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode() != HttpStatus.OK;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new BaseHttpClientErrorException(response.getStatusCode(), response.getStatusText());

    }

    protected void logError(){
        log.error("Формируем исключение!");
    }
}
