package org.example.request;

import lombok.Data;
import org.example.entity.RoleName;

import javax.validation.constraints.Email;

@Data
public class CreateCustomerRequest {

  //  @NotBlank(message = "cannot-be-empty")
//  @Size(min = 10, max = 10, message = "CustomerId-is-not-valid")
  private String customerId;

//  @Size(min = 9, max = 12, message = "CMND-is-not-valid")
  private String cmnd;

  //  @NotBlank(message = "cannot-be-empty")
  private String name;

  //  @NotBlank(message = "cannot-be-empty")
  private String taxCode;

  //  @NotBlank(message = "cannot-be-empty")
  private String phoneNumber;

  private String clientId;

  @Email(message = "email-not-valid")
  private String email;

  private RoleName roleName;

  //  @NotBlank(message = "cannot-be-empty")
//  @Size(min = 6, max = 50, message = "length-must-be-at-least-6-characters-and-max-50")
  private String password;

}

