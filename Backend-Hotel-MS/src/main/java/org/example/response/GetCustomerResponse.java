package org.example.response;

import lombok.Data;

@Data
public class GetCustomerResponse {

  private String customerId;
  private String cmnd;
  private String name;
  private String phoneNumber;
  private String email;
  private String clientId;
  private String taxCode;

}
