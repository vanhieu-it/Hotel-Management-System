package org.example.specification.roomclass;

import lombok.Data;
import org.example.entity.RoomCategoryName;
import org.example.entity.RoomTypeName;

@Data
public class RoomClassCriteria {

  private String roomClassName;
  private RoomCategoryName roomCategoryName;
  private RoomTypeName roomTypeName;

}
