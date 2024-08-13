package ru.home.restSimpleDemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.IOUtils;
import ru.home.restSimpleDemo.exception.IntegrationHttpClientErrorException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class MinikubeRestTemplateResponseErrorHandler extends  BaseRestTemplateErrorHandler{
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("#===xxx=====");
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = response.getBody();

        String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        System.out.println("#MeSSaGe:" + result);

        logError();
        throw new IntegrationHttpClientErrorException(response.getStatusCode(), response.getStatusText());

    }
}
