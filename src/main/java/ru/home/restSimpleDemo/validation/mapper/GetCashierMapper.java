package ru.home.restSimpleDemo.validation.mapper;

import org.mapstruct.Mapper;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.validation.dto.GetCashierRqValidationDTO;

@Mapper
public interface GetCashierMapper {
    GetCashierRqValidationDTO getGetCashierRqValidationDTO(GetCashierRq getCashierRq);
}
