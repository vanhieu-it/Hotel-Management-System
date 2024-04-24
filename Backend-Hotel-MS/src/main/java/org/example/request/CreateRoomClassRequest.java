package org.example.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateRoomClassRequest {

  @NotBlank(message = "cannot-be-empty")
  private String roomClassName;
  private String  roomTypeName;
  private String roomCategoryName;

  @NotBlank(message = "cannot-be-empty")
  private String description;

  @Min(value = 0, message = "must-be-greater-0")
  private Long price;

}
