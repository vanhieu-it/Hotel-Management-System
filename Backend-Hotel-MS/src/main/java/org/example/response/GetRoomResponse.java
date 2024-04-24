package org.example.response;

import lombok.Data;
import org.example.entity.RoomCategoryName;
import org.example.entity.RoomStatusName;

import java.math.BigDecimal;

@Data
public class GetRoomResponse {

  private String roomCode;
  private String roomTypeName;
  private RoomCategoryName roomCategoryName;
  private String description;
  private BigDecimal price;
  private RoomStatusName roomStatusName;

}
