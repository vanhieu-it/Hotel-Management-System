
package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateRoomRequest {

  @NotBlank(message = "cannot-be-empty")
  private String newRoomCode;

  @NotBlank(message = "cannot-be-empty")
  private String description;

  @NotNull(message = "cannot-be-empty")
  private Integer roomClassId;

  private String roomStatusName;


}
