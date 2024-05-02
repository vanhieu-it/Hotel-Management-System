package org.example.specification.roomclass;

import org.springframework.data.jpa.domain.Specification;
import org.example.entity.RoomCategoryName;
import org.example.entity.RoomClass;
import org.example.entity.RoomTypeName;

public final class RoomClassSpecifications {

  public static Specification<RoomClass> getFilter(
      RoomClassCriteria roomClassCriteria) {
    Specification<RoomClass> specification =
        Specification.where(null);
    if (roomClassCriteria.getRoomClassName() != null) {
      specification = specification
          .and(roomClassNameContains(roomClassCriteria.getRoomClassName()));
    }

    if (roomClassCriteria.getRoomCategoryName() != null) {
      specification = specification
          .and(belongsToRoomCategoryName(roomClassCriteria.getRoomCategoryName()));
    }

    return specification;
  }


  static Specification<RoomClass> roomClassNameContains(String name) {
    return (roomClass, cq, cb) -> cb.like(roomClass.get("roomClassName"), name);
  }

  static Specification<RoomClass> belongsToRoomTpeName(RoomTypeName roomTypeName) {
    return (roomClass, cq, cb) -> cb
        .equal(roomClass.get("roomType").get("roomTypeName"), roomTypeName);
  }

  static Specification<RoomClass> belongsToRoomCategoryName(RoomCategoryName roomCategoryName) {
    return (roomClass, cq, cb) -> cb
        .equal(roomClass.get("roomCategory").get("roomCategoryName"), roomCategoryName);
  }


}

