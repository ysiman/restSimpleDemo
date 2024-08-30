package ru.home.restSimpleDemo.Service;

import org.springframework.stereotype.Service;
import ru.home.restSimpleDemo.Integration.minikube.CashierIntegrationService;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;
import ru.home.restSimpleDemo.exception.IntegrationHttpClientErrorException;
import ru.home.restSimpleDemo.exception.MinikubeServiceException;

@Service
public class CashierServiceImpl implements CashierService {
    private final CashierIntegrationService integrationService;

    public CashierServiceImpl(CashierIntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @Override
    public GetCashierRs getCashier(GetCashierRq request) throws MinikubeServiceException {
        try {
            return integrationService.getCashier(new GetCashierRq());
        } catch (IntegrationHttpClientErrorException exception) {
            throw new MinikubeServiceException("Ошибка метода getCashier", exception, exception.getHttpStatus());
        }
    }

}
