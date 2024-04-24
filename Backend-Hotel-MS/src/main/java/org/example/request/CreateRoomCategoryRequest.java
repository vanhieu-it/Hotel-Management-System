package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateRoomCategoryRequest {

  @NotBlank(message = "cannot-be-empty")
  @Size(min = 2, max = 10, message = "length-must-be-at-least-2-characters-and-max-10")
  private String roomCategoryCode;

  private String roomCategoryName;

}
