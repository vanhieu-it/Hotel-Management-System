package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateRoomRequest {

//  @NotBlank(message = "cannot-be-empty")
//  @Size(min = 2, max = 10, message = "length-must-be-at-least-2-characters-and-max-10")
  private String roomCode;

  private String description;

  @NotNull(message = "cannot-be-empty")
  private Integer roomClassId;


}
