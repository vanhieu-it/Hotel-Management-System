package org.example.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetHotelServiceResponse {

  private Integer id;
  private String serviceName;
  private String description;
  private BigDecimal price;

}
