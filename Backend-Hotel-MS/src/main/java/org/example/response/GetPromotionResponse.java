package org.example.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GetPromotionResponse {

  private Integer id;
  private String promotionName;
  private LocalDate startAtDate;
  private LocalDate endAtDate;
  private List<GetPromotionDetailResponse> promotionDetailResponses;

}
