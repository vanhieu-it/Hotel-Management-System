package org.example.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateRoomClassRequest {

  @NotBlank(message = "cannot-be-empty")
  private String roomClassName;
  @NotBlank(message = "cannot-be-empty")
  private String description;

  @Min(value = 1, message = "must-be-greater-than-0")
  private Long price;

}
