package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateRoomTypeRequest {

  @NotBlank(message = "cannot-be-empty")
  private String roomTypeName;


}
