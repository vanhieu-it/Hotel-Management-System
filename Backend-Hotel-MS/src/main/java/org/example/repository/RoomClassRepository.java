
package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.example.entity.RoomClass;

import java.util.Optional;

public interface RoomClassRepository extends JpaRepository<RoomClass, Integer>,
    JpaSpecificationExecutor<RoomClass> {

  Boolean existsByRoomCategoryRoomCategoryNameAndRoomTypeRoomTypeName(String roomCategoryName,
      String roomTypeName);

  Boolean existsByRoomCategoryRoomCategoryNameAndRoomTypeRoomTypeNameAndIdNot(
      String roomCategoryName,
      String roomTypeName,
      Integer id);

  boolean existsByRoomCategory_RoomCategoryCodeAndRoomType_RoomTypeCode(String categoryCode,
      String typeCode);

  boolean existsByRoomClassName(String name);

  Optional<RoomClass> findByRoomClassName(String roomClassName);
}
