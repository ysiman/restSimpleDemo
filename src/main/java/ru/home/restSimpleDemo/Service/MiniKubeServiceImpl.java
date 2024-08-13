package ru.home.restSimpleDemo.Service;

import org.springframework.stereotype.Service;
import ru.home.restSimpleDemo.Integration.minikube.MinikubeIntegrationService;
import ru.home.restSimpleDemo.exception.IntegrationHttpClientErrorException;
import ru.home.restSimpleDemo.exception.MinikubeServiceException;

@Service
public class MiniKubeServiceImpl implements MiniKubeService {
    private final MinikubeIntegrationService minikubeIntegrationService;

    public MiniKubeServiceImpl(MinikubeIntegrationService minikubeIntegrationService) {
        this.minikubeIntegrationService = minikubeIntegrationService;
    }

    @Override
    public String getErrFromMinikube() throws MinikubeServiceException {
        try {
            return minikubeIntegrationService.getErrFromMinikube();
        } catch (IntegrationHttpClientErrorException exception) {
            throw new MinikubeServiceException("Ошибка метода getErr", exception, exception.getHttpStatus());
        }
    }

    @Override
    public String getTimeOutFromMinikube() throws MinikubeServiceException {
        try {
            return minikubeIntegrationService.getTimeOutFromMinikube();
        } catch (IntegrationHttpClientErrorException exception) {
            System.out.println("#=====xXx=====Ошибка метода getTimeOut");
            throw new MinikubeServiceException("Ошибка метода getTimeOut", exception, exception.getHttpStatus());
        } catch (Exception exception) {
            System.out.println("#=====xXx=====Ошибка метода getTimeOut2");
            throw new MinikubeServiceException("Ошибка метода getTimeOut");
        }
    }
}
