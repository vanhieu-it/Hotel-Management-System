package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateCustomerRequest {

  @NotBlank(message = "cannot-be-empty")
  @Size(min = 9, max = 12, message = "CMND-is-not-valid")
  private String cmnd;

  @NotBlank(message = "cannot-be-empty")
  private String name;

  @NotBlank(message = "cannot-be-empty")
  private String phoneNumber;

  @NotBlank(message = "cannot-be-empty")
  private String clientId;

}
