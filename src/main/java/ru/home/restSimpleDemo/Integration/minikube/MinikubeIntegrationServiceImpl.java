package ru.home.restSimpleDemo.Integration.minikube;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.home.restSimpleDemo.Integration.RestIntegrationService;
import ru.home.restSimpleDemo.dto.MinikubeRq;
import ru.home.restSimpleDemo.dto.MinikubeRs;

@Service
@Slf4j
public class MinikubeIntegrationServiceImpl extends RestIntegrationService implements MinikubeIntegrationService {
    private static final String MINIKUBE_ENDPOINT = "/demo/test";
    public MinikubeIntegrationServiceImpl(RestTemplate minikubeRestTemplate) {
        super(minikubeRestTemplate);
    }

    @Override
    public MinikubeRs getInfoFromMinikube(MinikubeRq request) {
        log.info("Отправка запроса в миникуб");
        String uri = UriComponentsBuilder.fromPath(MINIKUBE_ENDPOINT).toUriString();
        return sendHttpRequest(uri, HttpMethod.POST, new HttpEntity<>(request), MinikubeRs.class);
    }

    @Override
    public String getIntegrationName() {
        return "Minikube";
    }
}
