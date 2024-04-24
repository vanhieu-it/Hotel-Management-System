package org.example.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

  @NotEmpty(message = "cannot-be-empty")
  private String email;

  @NotEmpty(message = "cannot-be-empty")
  private String password;

}