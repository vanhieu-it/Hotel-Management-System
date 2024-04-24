package org.example.response;

import lombok.Data;

@Data
public class GetRoomClassResponse {

  private Integer id;
  private String roomClassName;
  private String roomTypeName;
  private String image;
  private String roomCategoryName;
  private String description;
  private Long price;
  private float promotionValue;

}
