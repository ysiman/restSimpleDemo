package ru.home.restSimpleDemo.Service;

import ru.home.restSimpleDemo.exception.MinikubeServiceException;

public interface MiniKubeService {

    String getErrFromMinikube() throws MinikubeServiceException;

    String getTimeOutFromMinikube() throws MinikubeServiceException;
}
