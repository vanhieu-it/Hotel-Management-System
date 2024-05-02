package org.example.specification.room;

import lombok.Data;
import org.example.entity.RoomCategoryName;
import org.example.entity.RoomStatusName;
import org.example.entity.RoomTypeName;

@Data
public class RoomCriteria {

  private RoomCategoryName roomCategoryName;
  private RoomTypeName roomTypeName;
  private RoomStatusName roomStatusName;

}
