package ru.home.restSimpleDemo.Scenario;

import org.springframework.http.ResponseEntity;

public interface HttpResponseScenario<Rq, Rs> {
    ResponseEntity<Rs> execute(Rq request);
}
