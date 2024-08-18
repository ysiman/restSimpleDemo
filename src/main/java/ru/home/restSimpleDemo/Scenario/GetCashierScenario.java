package ru.home.restSimpleDemo.Scenario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;
import ru.home.restSimpleDemo.validation.validator.ApiRequestValidator;

@Slf4j
@Component
public class GetCashierScenario extends AbstractHttpResponseScenario<GetCashierRq, GetCashierRs> {

    public GetCashierScenario(ApiRequestValidator<GetCashierRq> requestValidator) {
        super(requestValidator);
    }

    @Override
    protected GetCashierRs executeScenario(GetCashierRq apiRequest) {
        GetCashierRs getCashierRs = new GetCashierRs();
        getCashierRs.firstName("Donald");
        getCashierRs.lastName("Trump");
        return  getCashierRs;
    }
}
