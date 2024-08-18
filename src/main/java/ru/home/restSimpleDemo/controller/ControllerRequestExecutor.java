package ru.home.restSimpleDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

@Slf4j
public final class ControllerRequestExecutor {
    private ControllerRequestExecutor() {
    }

    /**
     * Метод описывающий логику обработки запроса в контроллере
     *
     * @param requestExecutor метод который выполняет обработку запроса
     * @param apiRequest объект АПИ
     * @return          возращает ответ с результатом обрабоки АПИ запроса
     */
    public static <Rq, Rs>ResponseEntity<Rs> processRequest(Function<Rq, Rs> requestExecutor, Rq apiRequest){
        Rs response = requestExecutor.apply(apiRequest);
        return ResponseEntity.ok().body(response);
    }
}
