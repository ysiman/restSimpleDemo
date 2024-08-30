package ru.home.restSimpleDemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import ru.home.restSimpleDemo.dto.validation.ValidationError;
import ru.home.restSimpleDemo.exception.IntegrationHttpClientErrorException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class CashierRestTemplateResponseErrorHandler extends BaseRestTemplateErrorHandler {
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("#===xxx=====");
        ObjectMapper mapper = new ObjectMapper();
        ValidationError validationError = mapper.readValue(response.getBody(), ValidationError.class);
        log.error("Ошибка валидации code: {}, desc: {} ", validationError.getCode(), validationError.getDesc());
        logError();
        throw new IntegrationHttpClientErrorException(response.getStatusCode(), response.getStatusText());

    }
}
