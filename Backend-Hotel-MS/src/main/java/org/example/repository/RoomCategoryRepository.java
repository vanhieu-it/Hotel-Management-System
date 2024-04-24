package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.RoomCategory;

import java.util.Optional;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, String> {

  Boolean existsByRoomCategoryName(String roomCategoryName);

  Boolean existsByRoomCategoryCode(String roomCategoryCode);

  Optional<RoomCategory> findByRoomCategoryName(String roomCategoryName);

  Optional<RoomCategory> findByRoomCategoryCode(String roomCategoryCode);


}
