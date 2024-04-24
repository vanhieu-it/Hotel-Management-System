package org.example.response;

import lombok.Data;

@Data
public class GetBookingCardDetailsResponse {

  private String roomClassId;
  private String roomClassName;
  private Integer quantity;
  private String image;
  private float promotionValue;
  private Long price;


}
