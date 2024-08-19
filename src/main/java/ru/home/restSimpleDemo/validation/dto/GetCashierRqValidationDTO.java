package ru.home.restSimpleDemo.validation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.home.restSimpleDemo.validation.annotation.AnyDashInUid;


@Data
@NoArgsConstructor
public class GetCashierRqValidationDTO {

  @NotNull
  @Size(max = 10, message = "Превышен размер UID")
  @AnyDashInUid(message = "В uid должно присутсвовать тире")
  private String uid;

  @NotNull
  private String clientEpkId;
}

