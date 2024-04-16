package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.RoomType;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {

  Boolean existsByRoomTypeName(String roomTypeName);

  Boolean existsByRoomTypeCode(String roomTypeCode);

  Optional<RoomType> findByRoomTypeName(String roomTypeName);

  Optional<RoomType> findByRoomTypeCode(String roomTypeCode);

}
