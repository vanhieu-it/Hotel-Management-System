package org.example.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UpdateDepositRequest {

  @Min(value = 0, message = "must-be-greater-than-or-same-as-0")
  private Long deposit;

}
