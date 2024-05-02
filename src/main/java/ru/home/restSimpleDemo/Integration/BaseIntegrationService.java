package ru.home.restSimpleDemo.Integration;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

import static ru.home.restSimpleDemo.Helper.LogHelper.objectToJson;

@Slf4j
public abstract class BaseIntegrationService {

    public <Rq, Rs> Rs invokeIntegrationRequest(Function<Rq, Rs> function, Rq request){
        log.info("Отправка зпроса в {}", getIntegrationName());
        Rs response = function.apply(request);
        log.info("Ответ: {}", objectToJson(response));
        return response;
    }

    public abstract String getIntegrationName();
}
