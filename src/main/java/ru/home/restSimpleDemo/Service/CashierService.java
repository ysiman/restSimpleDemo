package ru.home.restSimpleDemo.Service;

import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRs;
import ru.home.restSimpleDemo.exception.MinikubeServiceException;

public interface CashierService {

    GetCashierRs getCashier(GetCashierRq request) throws MinikubeServiceException;

}
