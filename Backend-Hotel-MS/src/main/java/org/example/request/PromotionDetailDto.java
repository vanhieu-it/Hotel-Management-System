package org.example.request;


import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PromotionDetailDto {

  private Integer roomClassId;

  @Min(value = 1, message = "must-be-greater-than-0")
  private float value;

}
