package ru.home.restSimpleDemo.Integration.minikube;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.home.restSimpleDemo.Integration.RestIntegrationService;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;

@Service
@Slf4j
public class CashierIntegrationServiceImpl  extends RestIntegrationService implements CashierIntegrationService{
    private static final String MINIKUBE_ENDPOINT = "/demo/test";

    public CashierIntegrationServiceImpl(RestTemplate cashierRestTemplate) {
        super(cashierRestTemplate);
    }

    @Override
    public GetCashierRs getCashier(GetCashierRq request) {
        log.info("Отправка запроса в миникуб для получения вносителя");
//        String uri = UriComponentsBuilder.fromPath("http://172.24.229.189:31504/demo").toUriString();
        return sendHttpRequest("http://172.24.229.189:31504/err", HttpMethod.GET, null, GetCashierRs.class);
    }

    @Override
    public String getIntegrationName() {
        return "CashierIntegration";
    }
}
