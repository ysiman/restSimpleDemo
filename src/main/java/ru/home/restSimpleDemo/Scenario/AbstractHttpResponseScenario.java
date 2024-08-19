package ru.home.restSimpleDemo.Scenario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import ru.home.restSimpleDemo.validation.validator.ApiRequestValidator;

import java.util.Optional;

@Slf4j
public abstract class AbstractHttpResponseScenario<Rq, Rs> implements HttpResponseScenario<Rq, Rs> {
    private final ApiRequestValidator<Rq> requestValidator;

    public AbstractHttpResponseScenario(ApiRequestValidator<Rq> requestValidator) {
        this.requestValidator = requestValidator;
    }

    @Override
    public ResponseEntity<Rs> execute(Rq apiRequest) {
        log.info("Начало выполнения сценария {}", getScenarioName());
        validateRequest(apiRequest);
        Rs apiResponse = executeScenario(apiRequest);
        log.info("Сцкнарий {} выполнен успешно", getScenarioName());
        return ResponseEntity.of(Optional.ofNullable(apiResponse));

    }

    protected void validateRequest(Rq apiRequest) {
        requestValidator.validate(apiRequest);
    }

    protected abstract Rs executeScenario(Rq apiRequest);

    private String getScenarioName() {
        return this.getClass().getSimpleName();
    }
}
