package org.example.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BookingCardDetailDto {


  @NotNull(message = "cannot-be-null")
  private Integer roomClassId;

  @NotNull(message = "cannot-be-null")
  @Min(value = 1, message = "must-be-greater-than-0")
  private Integer quantity;

}
