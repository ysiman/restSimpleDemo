package ru.home.restSimpleDemo.Integration.minikube;

import ru.home.restSimpleDemo.dto.MinikubeRq;
import ru.home.restSimpleDemo.dto.MinikubeRs;

public interface MinikubeIntegrationService {
    public MinikubeRs getInfoFromMinikube(MinikubeRq request);
}
