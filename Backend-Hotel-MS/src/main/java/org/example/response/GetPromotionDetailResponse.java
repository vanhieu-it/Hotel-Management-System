package org.example.response;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetPromotionDetailResponse {

  private Integer roomClassId;
  private String roomClassName;
  private BigDecimal value;

}
