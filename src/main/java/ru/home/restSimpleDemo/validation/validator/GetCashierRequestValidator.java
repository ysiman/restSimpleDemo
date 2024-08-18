package ru.home.restSimpleDemo.validation.validator;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.home.restSimpleDemo.dto.external.model.GetCashierRq;
import ru.home.restSimpleDemo.validation.dto.GetCashierRqValidationDTO;
import ru.home.restSimpleDemo.validation.mapper.GetCashierMapper;


@Component
public class GetCashierRequestValidator extends BaseRequestDtoValidator<GetCashierRq> {
    private final GetCashierMapper mapper;

    @Autowired
    public GetCashierRequestValidator(Validator validator, GetCashierMapper mapper) {
        super(validator);
        this.mapper = mapper;
    }

    @Override
    protected GetCashierRqValidationDTO convertRequestToValidationDto(GetCashierRq request) {
        return mapper.getGetCashierRqValidationDTO(request);
    }
}
