package ru.home.restSimpleDemo.Integration.minikube;

import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;

public interface CashierIntegrationService {
    public GetCashierRs getCashier(GetCashierRq request);
}
