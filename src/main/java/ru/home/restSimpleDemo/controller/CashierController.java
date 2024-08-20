package ru.home.restSimpleDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.restSimpleDemo.Scenario.HttpResponseScenario;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;

@RestController
public class CashierController {
    private final HttpResponseScenario<GetCashierRq, GetCashierRs> getCashierScenario;

    public CashierController(HttpResponseScenario<GetCashierRq, GetCashierRs> getCashierScenario) {
        this.getCashierScenario = getCashierScenario;
    }

//     @RequestMapping( value = "/cashier", method = RequestMethod.POST, headers = "Accept=application/json")
    @PostMapping(path = "/cashier", consumes = "application/json")
    public ResponseEntity<GetCashierRs> getCashier(@RequestBody GetCashierRq request){
        return getCashierScenario.execute(request);
    }

}
