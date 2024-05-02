package org.example.specification.room;

import org.springframework.data.jpa.domain.Specification;
import org.example.entity.Room;
import org.example.entity.RoomCategoryName;
import org.example.entity.RoomStatusName;
import org.example.entity.RoomTypeName;

public final class RoomSpecifications {

  public static Specification<Room> getFilter(
      RoomCriteria roomCriteria) {
    Specification<Room> specification =
        Specification.where(null);
    if (roomCriteria.getRoomStatusName() != null) {
      specification = specification
          .and(belongToRoomStatus(roomCriteria.getRoomStatusName()));
    }
    if (roomCriteria.getRoomTypeName() != null) {
      specification = specification
          .and(belongToRoomType(roomCriteria.getRoomTypeName()));
    }
    if (roomCriteria.getRoomCategoryName() != null) {
      specification = specification
          .and(belongToRoomCategory(roomCriteria.getRoomCategoryName()));
    }
    return specification;
  }


  static Specification<Room> belongToRoomStatus(RoomStatusName roomStatusName) {
    return (room, cq, cb) -> cb.equal(room.get("roomStatus"), roomStatusName);
  }

  static Specification<Room> belongToRoomCategory(RoomCategoryName roomCategoryName) {
    return (room, cq, cb) -> cb
        .equal(room.get("roomClass").get("roomCategory").get("roomCategoryName"), roomCategoryName);
  }

  static Specification<Room> belongToRoomType(RoomTypeName roomTypeName) {
    return (room, cq, cb) -> cb
        .equal(room.get("roomClass").get("roomType").get("roomTypeName"), roomTypeName);
  }


}

