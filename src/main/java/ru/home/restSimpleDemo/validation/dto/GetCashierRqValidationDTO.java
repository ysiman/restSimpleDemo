package ru.home.restSimpleDemo.validation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class GetCashierRqValidationDTO {

  @NotNull
  @Size(max = 5, message = "Превышен размер UID")
  private String uid;

  @NotNull
  private String clientEpkId;
}

